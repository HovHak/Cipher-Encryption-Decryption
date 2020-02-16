### Cipher Encryption Decryption
 
## My Cipher

------


My algorithm implements two different encrypting/decrypting approaches in which the English letters of plaintext are mapped together into a cipher text. As part of creating my own cipher I have decided to unite monoalphabetic and transposition techniques that will map a perfect cipher that would be hard to decrypt even if the key would be available to a third-party user. My algorithm is based on 3 stages that work sequentially which makes it complex yet simple for a small encryption/decryption algorithm. First stage consist of applying affine method for encryption. Second stage, generating third key to improve affine, applying rivers transposition to the cipher text.

------
#### Note
* The transposition technique is used only in the end of the encryption and at beginning of the decryption


### Affine
For monoalphabetic cipher I have implemented the Affine cipher that is considered as substitution cipher, where each letter in alphabet is mapped to its numeric equivalent. There are two formulas that are used for Affine, one for encryption and other for decryption. It uses modular arithmetic to transform the integer that each plaintext corresponds to into another integer that correspond to a ciphertext letter. (Check formula1)
#### Formula 1

<p align="center"><img src = "images/formula1.PNG" ></p>


Affine takes two numeric keys to perform its encryption based on that it uses the formula listed above to perform encryption for each letter of the plain-text, where the ‘a’ and ‘b’ are the first and the second keys and ‘m’ represents the size of the alphabet used, in this case it is 26 for English letters.
As for the decryption, Affine also uses both keys, but to perform decryption it must calculate the inverse modular multiplication. Thus, it uses formula (Check formula2) however to be able and calculate the inverse modular multiplication will only be possible if the first key ‘a’ and number of alphabet ‘m’ (in our case is 26) are coprime such that given the (key * x) mod 26 = 1, where the value ‘x’ will always be different and will be test from 0 to 26 until it finds the exact number that will coprime ‘a’ and ‘m’(check the example in formula3 given the firs key as 17).
#### Formula 2

<p align="center"><img src = "images/formula2.PNG" ></p>

#### Formula 3

<p align="center"><img src = "images/formula3.PNG" ></p>

Uniqueness
