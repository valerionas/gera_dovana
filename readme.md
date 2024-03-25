# Page "Gera Dovana" automated tests

## Test scenarios:

1. Login
2. Services Search
3. Add to Cart

## Login

**With correct input:**

1. Open home page
2. Accept cookies, close popup windows
3. Drag mouse on "Prisijungti" in top right corner
4. Press button "Prisijungti"
5. Input email
6. Input Password
7. Press button "Prisijungti"  
   **Expected result:** We navigate to homepage and in top right corner instead of "Prisijungti" we see "Profilis".

**With incorrect input:**

1. Open home page
2. Accept cookies, close popup windows
3. Drag mouse on "Prisijungti" in top right corner
4. Press button "Prisijungti"
5. Input incorrect email
6. Input incorrect Password
7. Press button "Prisijungti"  
   **Expected result:** Error message appears.

## Services search and filtering

**Search phrase and price filtering**

1. Open home page
2. Accept cookies, close popup windows
3. Input text to search bar
4. Click on search icon  
5. Get entries
   **Expected result:** All entries include search phrase or a synonym in the title (and price is appropriate)

~~**Price selector component filtering**~~

~~1. Open home page~~  
~~2. Accept cookies, close popup windows~~  
~~3. Input text to search bar~~  
~~4. Click on search icon~~  
~~5. Click and drag price selection element~~  
~~**Expected result:** All entries include search phrase or a synonym in the title (and price is appropriate)~~

## Add to cart

1. Do a search for a product.
2. Select product
3. Press "Idėti į krepšelį"
4. Go back for a second item
5. Repeat steps 2. and 3. once
6. Count items added.
7. Calculate actual total price  
   **Expected Result:** Both items are in the cart and total price is equals shown Price.

### Sources:

- https://stackoverflow.com/questions/4777622/creating-a-list-of-pairs-in-java
- https://stackoverflow.com/questions/156275/what-is-the-equivalent-of-the-c-pairl-r-in-java?noredirect=1&lq=1
- https://www3.ntu.edu.sg/home/ehchua/programming/howto/Regexe.html#:~:text=To%20match%20a%20character%20having,%22%20(back%2Dslash).
- https://regexone.com/
- https://www.baeldung.com/java-find-numbers-in-string
- https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
- https://stackoverflow.com/questions/4662215/how-to-extract-a-substring-using-regex