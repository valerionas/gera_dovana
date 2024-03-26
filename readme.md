# Page "Gera Dovana" automated tests

## Test scenarios:

1. Login
2. Search and filtering feature
3. Add to Cart

## Login

**With correct input:**  
**testLogin_ProvidedCorrectInput()**

1. Open home page
2. Accept cookies, close popup windows
3. Drag mouse on "Prisijungti" in top right corner
4. Press button "Prisijungti"
5. Input email
6. Input Password
7. Press button "Prisijungti"  
   **Expected result:** We navigate to homepage and in top right corner instead of "Prisijungti" we see "Profilis".

**With incorrect input:**  
**testLogin_ProvidedIncorrectInput()**

1. Open home page
2. Accept cookies, close popup windows
3. Drag mouse on "Prisijungti" in top right corner
4. Press button "Prisijungti"
5. Input incorrect email
6. Input incorrect Password
7. Press button "Prisijungti"  
   **Expected result:** Error message appears.

## Search and filtering feature

**Search phrase filtering**  
**testTitlesOfSearchService()**

1. Open home page
2. Accept cookies, close popup windows
3. Input text to search bar
4. Click on search icon 
5. Get titles of entries   
   **Expected result:** All entries include search phrase or a synonym in the title

**Filtering by price**  
**testPricesOfSearchService()**

1. Open home page
2. Accept cookies, close popup windows
3. Input text to search bar
4. Click on search icon
5. Drag slider element of minimum price to the right
6. Drag slider element of maximum price to the left
7. Read minimum and maximum prices
8. Get prices of entries  
   **Expected result:** All prices of entries falls into the interval of minimum and maximum value


## Add to cart

**Adding items to cart**  
**testAddToCart()**

1. Do a search for a product. *(Steps 1 to 4 from Search feature tests)*
2. Select product
3. Press "Idėti į krepšelį"
4. Go back for a second item
5. Repeat steps 2. and 3. once
6. Count items added.
7. Add item quantity to the first item
8. Calculate actual total price  
   **Expected Result:** Both items are in the cart and total price is equals shown price.

### Sources:

- [List of pairs](https://stackoverflow.com/questions/4777622/creating-a-list-of-pairs-in-java)
- [List of pairs2](https://stackoverflow.com/questions/156275/what-is-the-equivalent-of-the-c-pairl-r-in-java?noredirect=1&lq=1)
- [Regex](https://www3.ntu.edu.sg/home/ehchua/programming/howto/Regexe.html#:~:text=To%20match%20a%20character%20having,%22%20(back%2Dslash))
- [Regex Interactive](https://regexone.com/)
- [Extract substring with Regex](https://stackoverflow.com/questions/4662215/how-to-extract-a-substring-using-regex)
- [Find numbers in strings](https://www.baeldung.com/java-find-numbers-in-string)
- [Round a Double](https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places)