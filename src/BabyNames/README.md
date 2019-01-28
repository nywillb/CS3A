# Baby Names Project

> © Copyright 2019 William Barkoff, William Ricci, Hannah Levin. MIT Licensed

This project was created for the "Advanced Data Structures and Algorithims A" course at the Dalton School. The assignment was to take the list of baby names at [New York City Open Data](https://data.cityofnewyork.us/Health/Popular-Baby-Names/25th-nujf) and organize it in a way that you could access any name as quickly as possible by searching for the first few letters.

## Usage
There are serveral different ways of using this project.

### CSV From New York City Open Data

Use the enclosed `main.java` file. Make sure to update the line
```java
Reader dataFile = new FileReader("resources/BabyNames/babynames.csv");
```
to the correct path to your csv file. Also, change the line
```java
        Name[] results = tree.search("han");
```
to your search term. Remove any non `A`-`z` characters from the list. As of 1/28/19, there were only `'` characters that needed to be removed. Note that the `main.java` file requires the [Apache Commons CSV](https://commons.apache.org/proper/commons-csv/) library as a dependancy.

### Proof of Concept
Run the enclosed `driver.java` file. It contains the following hardcoded data:



| Name | Count |
| ------- | ------ |
| ab      | 5      |
| abc     | 10     |
| acd     | 20     |
| zab     | 15     |
| xyz     | 48     |

It returns the results for the name search `a`.

### Use in your own code

You need to import the following classes.

- `Name`
- `AlphebeticalNameSearchTree`

You can add instances of `Name` to an instance of `AlphebeticalNameSearchTree` in order to sort the names. You can then use `AlphebeticalNameSearchTree`'s `search(string)` function to return an Array of names.

## Known Issues
- The only supported characters in names are a-z. Capital letters are automatically converted to lowercase, but any other character crashes the application.
- Alphebetical is spelled wrong throught the program. It got too annoying to refactor it once we noticed.

If you have any questions, feel free file an issue on GitHub. Pull requests are greatly appreciated.

## Licensing

This software is licensed under the MIT License.

``` 
Copyright 2019 William Barkoff, William Ricci, Hannah Levin

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.```
