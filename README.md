# AddressBook
## Version 2.5 Released!
I have just released version 2.5! This program has many improvemnts over the last version, 2.1! Change Log:
1. Complete re-write to improve stability and fix bugs!
2. More checks to make sure the data passed to the backend is in a good format
3. Helper class to allow for independent updates to the backend
4. Full split from AddressBookCLI allowing for easier use and smaller program files

## Why the Split?
The spilt of the backend and the frontend is to help allow me and anyone who wants to use this easier access to the core functions of the program! Also updates should be more reqular, when needed, to the backend since I don't have to work on the frontend and REST interface at the same time!

## What do I need to know?
### What's in the javadoc?
The javadoc is very useful. It expalins what each function does as well as describe each object breifely. For some functions it explains what field are required for each object. Ex in a person object you can keep the firstName string empty and the program will use the exisiting persons firstName when updating a given person etc.

### How can I include this program in my java project.
If you want to use this then the easiest way is to download the jar file either in the code section or from the releases tab. Both will be updated at the same time. Once downloaded all you need to do is include the jar in your build path and import it as needed!

### Is there a java doc available?
Yes! If you visit https://jnstockley.github.io/AddressBook/ the javadoc will be available there

### I found a bug or have a feature request what should I do?
If you found a bug you can submit the bug under the issues tab using the bug lable. If you have a feature request you can submit it under the issues tab using the enhancement lable.
