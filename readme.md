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

## Services search (and filtering by price maybe)

1. Open home page
2. Accept cookies, close popup windows
3. Input text to search bar 
4. Click on search icon
5. Click and drag price selection element  
   **Expected result:** Get at least *six* entries where title includes search phrase (and price is appropriate)

