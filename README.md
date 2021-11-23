# Dictionary-Attack
Finding possible passwords for the users from a given list of passwords using Java

- The Resources folder contains files such as Shadow file, Simple Shadow file & list ofCommon Passwords file.
- The Simple Shadow file contains  a text file  in which every line corresponds to one user. The format of each line is: 
username:salt:hash where “username” is the user’s ID, “salt” is a 8-character salt, and “hash” is the MD5 cryptographic hash of the 
string obtained by concatenating the salt with the user’s password. These fields are separated by the colon (:) 
character. 
- The shadow file is a text file  in which every line corresponds to 
one user. The format of each line is (fields are separated by the colon “:” character): username:shash:......(several other fields) 
The “username” field is the user’s ID. The salted hash “shash” field contains the following subfields (separated 
by the “$” character): 
$1$salt$hash 
- Common Passwords file contains the list of commonly used passwords.

- In Simple cracker, to obtain the cryptographic hash of a string of characters in Java, you can use the object 
MessageDigest. Because the hash is a string of characters, which may contain non-printable characters, the 
shadow file actually contains the hexadecimal representation of the characters. Note that the “shadow-simple” file is not a password shadow file as found on a real Linux system. The hashes are computed using a regular MD5 hash.

- In cacker, The hash has been generated this time using a more complex algorithm that is actually used in the 
Ubuntu Linux distribution. You are also provided with the file “MD5Shadow.java”, which contains a class that 
has the MD5Shadow.crypt() method, which receives a password and a salt, and generates the shadow-style 
hash. 
