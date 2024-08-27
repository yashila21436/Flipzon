    package com.company;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    class Coupon {
        private int discountPercentage;

        public Coupon (int discountPercentage){
            this.discountPercentage = discountPercentage;
        }

        public int getDiscountPercentage (){
            return this.discountPercentage;
        }
    }

    class Portal  {
        ArrayList<Category> categories;
        /*ArrayList<Product> products;*/
        ArrayList<Product> combinedOffer;
        ArrayList<User> registered;
        public Portal() {
            categories=new ArrayList<>();
           // products=new ArrayList<>();
            combinedOffer=new ArrayList<>();
            registered=new ArrayList<>();
        }
        public void menue() throws Exception {


            BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
            String choose = "0";
            Admin a1=new Admin();
            while(choose!="5") {
                System.out.println("Welcome to flipzone");
                System.out.println("1. Enter as Admin");
                System.out.println("2. Explore the catalogue ");
                System.out.println("3. Show available deals ");
                System.out.println("4. Enter as customer ");
                System.out.println("5. Exit the  Application ");
                choose = a.readLine();
                if (choose.equals("1")) {
                    String username = a.readLine();
                    String password = a.readLine();
                    a1.setPassword(password);
                    a1.setUsername(username);
                    System.out.println("You are now a registered admin. ");
                    System.out.println("Dear Admin ");
                    System.out.println("please enter username and password ");
                    String loginU = a.readLine();
                    String loginP = a.readLine();
                    while (true) {
                        if (loginU.equals(a1.getUsername()) && loginP.equals(a1.getPassword())) {
                            System.out.println("Welcome " + loginU);
                            System.out.println("1. Add Category ");
                            System.out.println("2. Delete Category ");
                            System.out.println("3. Add Product ");
                            System.out.println("4. Delete Product ");
                            System.out.println("5. Set discount on product ");
                            System.out.println("6. Add giveaway deal ");
                            System.out.println("7. Back ");
                            String opt=a.readLine();
                            int option=Integer.parseInt(opt);
                            if(option>=7 || option<=0){
                                break;
                            }
                            else if(option==1){

                                System.out.println("Enter the category ID ");
                                String newCategoryid=a.readLine();
                                System.out.println("Enter the category name ");

                                String newCategoryName=a.readLine();
                                categories=a1.addCategory(categories,newCategoryid,newCategoryName);


                            }
                            else if(option==2){
                                System.out.println("Enter Category ID");
                                String delid=a.readLine();
                                categories=a1.deleteCategory(categories,delid);
                            }

                            else if(option==3){
                                System.out.println("Enter category id");
                                String newpc=a.readLine();
                                System.out.println("Enter Product Name ");
                                String productname=a.readLine();
                                String productid=a.readLine();
                                String price=a.readLine();
                                String des=a.readLine();
                                categories=a1.addProduct(categories,newpc,productname,productid,price,des);

                            }
                            else if(option==4){
                                System.out.println("Enter Category id ");
                                String delpid=a.readLine();
                                System.out.println("Enter the Product id ");
                                String delprid=a.readLine();
                                categories=a1.deleteProduct(categories,delpid,delprid);
                            }
                            else if(option==5){
                                System.out.println("Enter the product id ");
                                String dispid=a.readLine();
                                String elite=a.readLine();
                                String prime=a.readLine();
                                String normal=a.readLine();
                                categories=a1.setDiscount(categories,dispid,elite,prime,normal);
                            }
                            else if(option==6){
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                System.out.println("Enter the first Product ID :");
                                String firstid=a.readLine();
                                System.out.println("Enter the second Product ID :");
                                String secid=a.readLine();
                                System.out.println("Price");
                                String cp=a.readLine();
                                combinedOffer=a1.deal(combinedOffer,firstid,secid,cp);
                            }




                        } else {
                            System.out.println("Incorrect credentials ");
                            break;
                        }
                    }

                }
                else if(choose.equals("2")){
                    for(int i=0;i<categories.size();i++){
                        System.out.println(categories.get(i).getCategoryName()+" "+categories.get(i).getCategoryID());
                        for(int j=0;j<categories.get(i).products.size();j++){
                            System.out.println(categories.get(i).products.get(j).getProductId()+" "+categories.get(i).products.get(j).getProductName()+" "+categories.get(i).products.get(j).getProductDescription()+" "+Integer.toString(categories.get(i).products.get(j).getPrice()));
                        }
                    }
                }
                else if(choose.equals("3")){
                    for(int i=0;i<combinedOffer.size();i++){
                        System.out.println(combinedOffer.get(i).getProductName()+" "+combinedOffer.get(i).getPrice());

                    }
                }
                else if(choose.equals("4")){

                    while(true) {
                        System.out.println("1.Sign up ");
                        System.out.println("2.Login ");
                        System.out.println("3. Back ");
                        String option=a.readLine();
                        int numberOption=Integer.parseInt(option);
                        if(numberOption==3){
                            break;
                        }
                        if(numberOption==1){
                            User u=new User();
                            System.out.println("Enter the Username");
                            String newUserUsername=a.readLine();
                            System.out.println("Enter the Password ");
                            String newUserPass=a.readLine();

                            u.setP(newUserPass);
                            u.setU(newUserUsername);
                            u.setUserStatus("Normal",0,5);
                            registered.add(u);
                            System.out.println("You have now been registered ");

                            u.setBalance(1000);
                        }
                        if(numberOption==2){
                            System.out.println("Enter the username ");
                            String ue=a.readLine();
                            System.out.println("Enter the password ");
                            String pe=a.readLine();
                            String c;
                            for(int i=0;i<registered.size();i++){

                                if(ue.equals(registered.get(i).getU())&& pe.equals(registered.get(i).getP())){
                                    User logedin=registered.get(i);
                                    while(true){
                                        System.out.println(" Welcome "+ registered.get(i).getU());
                                        System.out.println("1. browse products ");
                                        System.out.println("2. browse deals ");
                                        System.out.println("3. add a product to cart");
                                        System.out.println("4. add products in deal to cart");
                                        System.out.println("5. view coupons ");
                                        System.out.println("6. check account balance");
                                        System.out.println("7. view cart ");
                                        System.out.println("8. empty cart ");
                                        System.out.println("9. checkout cart ");
                                        System.out.println("10. update customer status ");
                                        System.out.println("11. Add amount to wallet ");
                                        System.out.println("12. Back ");
                                        c=a.readLine();
                                        int intChoice=Integer.parseInt(c);
                                        if(intChoice>=12 || intChoice<=0){
                                            break;
                                        }
                                        if(intChoice==1){
                                            for(int j=0;j<categories.size();j++){
                                                System.out.println(categories.get(j).getCategoryName()+" "+categories.get(j).getCategoryID());
                                                for(int k=0;k<categories.get(i).products.size();k++){
                                                    System.out.println(categories.get(j).products.get(k).getProductId()+" "+categories.get(j).products.get(k).getProductName()+" "+categories.get(i).products.get(j).getProductDescription()+" "+Integer.toString(categories.get(i).products.get(j).getPrice()));
                                                }
                                            }
                                        }
                                        if(intChoice==10){
                                            System.out.println("Current Status "+logedin.getUserStatus());
                                            System.out.println("give your new status ");
                                            String newStatus=a.readLine();
                                            int userSpecificDiscount = 0;
                                            int deliveryPercentage = 5;
                                            if (newStatus.equals("Prime")){
                                                userSpecificDiscount = 5;
                                                deliveryPercentage = 2;
                                            }
                                            else if (newStatus.equals("Elite")){
                                                userSpecificDiscount = 10;
                                                deliveryPercentage = 0;

                                            }
                                            logedin.setUserStatus(newStatus,userSpecificDiscount, deliveryPercentage);
                                            System.out.println("Status updated to "+newStatus);
                                            if(newStatus.equals("Elite")){
                                                if(logedin.getBalance()>=300){
                                                    double amount=logedin.getBalance()-300;
                                                    logedin.setBalance(amount);
                                                }
                                                else{
                                                    System.out.println("Insufficient balance ");
                                                }
                                            }
                                            else if(newStatus.equals("Prime")){
                                                if(logedin.getBalance()>=200) {
                                                    double amount = logedin.getBalance() - 200;
                                                    logedin.setBalance(amount);
                                                }
                                                else{
                                                    System.out.println("Insufficient balance");
                                                }
                                            }

                                        }
                                        else if(intChoice==6){
                                            for(int j=0;j<registered.size();j++){
                                                if(registered.get(j).getU().equals(ue)){
                                                    System.out.println("Current Balance in your account is "+Double.toString(logedin.getBalance()));
                                                    break;
                                                }
                                            }

                                        }
                                        else if(intChoice==5){
                                            logedin.printCouponList();

                                        }
                                        else if(intChoice==3){
                                            System.out.println("Enter the product ID ");
                                            String addPid=a.readLine();
                                            System.out.println("Quantity ");
                                            String quant=a.readLine();
                                            int quantity=Integer.parseInt(quant);
                                            logedin.addProductToCart(addPid,quantity);
                                            System.out.println("Product successfully added to cart ");


                                        }
                                        else if(intChoice==9){
                                            double bill=logedin.checkOutCart(categories,logedin.getUserStatus());
                                            double bal=logedin.getBalance();
                                            System.out.println(bill);
                                            if(bill>bal){
                                                System.out.println("Insufficient balance ");
                                            }
                                            else{

                                                System.out.println("Your order is successfully placed ");
                                                logedin.printCartItems(categories,logedin.getUserStatus());
                                                String status=logedin.getUserStatus();

                                                double newBalance=bal-bill-100;
                                                logedin.setBalance(newBalance);
                                                System.out.println("Final Amount will be "+Double.toString(bill));
                                                logedin.setCart(new Cart());

                                            }
                                        }
                                        else if(intChoice==8){
                                            logedin.setCart(new Cart());
                                            System.out.println("Cart successfully emptied ");
                                        }
                                        else if(intChoice==11){
                                            System.out.println("Enter the amount to be added ");
                                            String addAmount=a.readLine();
                                            int intAddAmount=Integer.parseInt(addAmount);
                                            double currentBal=logedin.getBalance();
                                            double newBal=currentBal+intAddAmount;
                                            logedin.setBalance(newBal);
                                            System.out.println("Amount added Successfully ");
                                        }
                                        else if(intChoice==7){
                                            logedin.viewCart();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else{
                    break;
                }
            }

        }
    }
    class Cart {


        private List<CartItem> cartItemList;
        public Cart(){
            this.cartItemList=new ArrayList<CartItem>();
        }
        public List<CartItem> getCartItemList() {
            return cartItemList;
        }
        public void addProductToCart(String id,int q){
            CartItem c=new CartItem();
            c.setId(id);
            c.setQuantity(q);
            this.cartItemList.add(c);
        }




    }

    class CartItem{
        private String productId;
        private int quantity;
        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public void setId(String id) {
            this.productId = id;
        }



    }
    class User {
        private String u;
        private String p;
        private String userStatus;
        private int discountPercentage;
        private int deliveryChargePercentage;
        private double balance;
        private Cart cart;
        private List<Coupon> couponList;
        public User(){
            this.cart=new Cart();
            this.couponList = new ArrayList<Coupon>();
            this.deliveryChargePercentage = 5;
        }
        public void setU(String u){
            this.u=u;
        }
        public void setP(String p){
            this.p=p;
        }
        public String getU(){
            return this.u;
        }
        public String getP(){
            return this.p;
        }
        public void setUserStatus(String userStatus, int discountPercentage, int deliveryChargePercentage){
            this.userStatus=userStatus;
            this.discountPercentage = discountPercentage;
            this.deliveryChargePercentage = deliveryChargePercentage;

        }
        public String getUserStatus(){
            return this.userStatus;
        }
        public void setBalance(double balance){
            this.balance=balance;
        }
        public double getBalance(){
            return this.balance;
        }

        public void printCouponList() {
            if (this.couponList.size() == 0){
                System.out.println("You have no coupons");
            }
            for (int j=0; j<this.couponList.size();j++){
                System.out.println("Coupon "+(j+1)+" : "+couponList.get(j).getDiscountPercentage()+" percent.");
            }
        }


        public void addProductToCart(String productId,int q){
            this.cart.addProductToCart(productId,q);
        }
        public double checkOutCart(ArrayList<Category> c,String status){
            double amount=0;
            String d="";
            int disc=0;
            int maxDiscountPercentageCoupon = 0;
            Coupon maxDiscountCoupon = null;
            for (int k=0;k<this.couponList.size();k++){
                if (this.couponList.get(k).getDiscountPercentage()>maxDiscountPercentageCoupon){
                    maxDiscountPercentageCoupon = this.couponList.get(k).getDiscountPercentage();
                    maxDiscountCoupon = this.couponList.get(k);
                }
            }

            this.couponList.remove(maxDiscountCoupon);
            double totalPriceForAllProducts = 0;
            for(int i=0;i<cart.getCartItemList().size();i++){
                for (int j=0;j<c.size();j++){
                    for(int k=0;k<c.get(j).products.size();k++){
                        if(c.get(j).products.get(k).getProductId().equals(cart.getCartItemList().get(i).getProductId())){
                            if(status.equals("Normal")){
                                d=c.get(j).products.get(k).getNormalDiscount();
                            }
                            else if(status.equals("Prime")){
                                d=c.get(j).products.get(k).getPrimeDiscount();
                            }
                            else if(status.equals("Elite")){
                                d=c.get(j).products.get(k).getEliteDiscount();
                            }
                            if(d==null){
                                disc=0;
                            }
                            else {
                                disc=Integer.parseInt(d);
                            }
                            double discForProduct = Math.max(disc,this.discountPercentage);
                            discForProduct = Math.max(discForProduct,maxDiscountPercentageCoupon);
                            double totalPriceForProduct = c.get(j).products.get(k).getPrice()*cart.getCartItemList().get(i).getQuantity();
                            totalPriceForAllProducts += totalPriceForProduct;
                            double da=(totalPriceForProduct*discForProduct)/100;
                            amount=amount+totalPriceForProduct-da;
                        }
                    }
                }
            }

            double deliveryCost = 100 + (totalPriceForAllProducts*this.deliveryChargePercentage/100);
            System.out.println("Delivery charge: "+deliveryCost);
            amount += deliveryCost;

            if ((amount >= 5000) && (this.userStatus.equals("Elite"))) {
                int numCoupons = (int)(Math.floor(Math.random()*2) + 3);
                System.out.println("You have won "+numCoupons+ " of following percentages:");
                for (int i=0; i<numCoupons; i++){
                    int percentage = (int)(Math.floor(Math.random()*11) + 5);
                    System.out.println(percentage + "%");
                    Coupon coupon = new Coupon(percentage);
                    this.couponList.add(coupon);
                }

            }
            else if ((amount >= 5000) && (this.userStatus.equals("Prime"))) {
                int numCoupons = (int)(Math.floor(Math.random()*2) + 1);
                System.out.println("You have won "+numCoupons+ " of following percentages:");
                for (int i=0; i<numCoupons; i++){
                    int percentage = (int)(Math.floor(Math.random()*11) + 5);
                    System.out.println(percentage + "%");
                    Coupon coupon = new Coupon(percentage);
                    this.couponList.add(coupon);
                }

            }


            return amount;
        }
        public void viewCart(){
            for(int i=0;i<this.cart.getCartItemList().size();i++){
                System.out.println(this.cart.getCartItemList().get(i).getProductId()+" "+this.cart.getCartItemList().get(i).getQuantity());
            }
        }
        public void printCartItems(ArrayList<Category> c,String status ){
            for(int i=0;i<cart.getCartItemList().size();i++){
                for(int j=0;j<c.size();j++){
                    for(int k=0;k<c.get(i).products.size();k++){
                        if(cart.getCartItemList().get(i).getProductId().equals(c.get(j).products.get(k).getProductId())){
                            System.out.println("Product Name: "+c.get(j).products.get(k).getProductName());
                            System.out.println("Product ID: "+c.get(j).products.get(k).getProductId());
                            System.out.println(c.get(j).products.get(k).getProductDescription());
                            System.out.println(c.get(j).products.get(k).getPrice());
                            if(status.equals("Normal")){
                                System.out.println(c.get(j).products.get(k).getNormalDiscount());
                            }
                            else if(status.equals("Prime")){
                                System.out.println(c.get(j).products.get(k).getPrimeDiscount());
                            }
                            else{
                                System.out.println(c.get(j).products.get(k).getEliteDiscount());
                            }
                        }
                    }
                }
            }
        }
        public void setCart(Cart c){
            this.cart=c;
        }




    }
    class Category{
        protected int categoryID;
        protected String categoryName;

        ArrayList<Product> products;
        public Category(){
            products=new ArrayList<>();
        }
        public void setCategoryID(int categoryID)
        {
            this.categoryID=categoryID;
        }
        public void setCategoryName(String categoryName){
            this.categoryName=categoryName;

        }
        public int getCategoryID()
        {
            return this.categoryID;
        }
        public String getCategoryName()
        {
            return this.categoryName;
        }



    }
    class Admin {
        private String username;
        private String password;

        public Admin() {

        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return this.password;
        }

        public ArrayList<Category> addCategory(ArrayList<Category> add, String id, String name) throws Exception {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            int intid = Integer.parseInt(id);
            for (int i = 0; i < add.size(); i++) {
                if (add.get(i).getCategoryID() == intid) {
                    System.out.println("ID already exists. Use aother one");
                    return add;
                }
            }
            Category c = new Category();
            c.setCategoryName(name);
            c.setCategoryID(intid);
            add.add(c);
            System.out.println("Add Product ");
            System.out.println("Product Name ");
            String ProductName = b.readLine();
            System.out.println("Product ID ");
            String ProductId = b.readLine();
            System.out.println("Product Description");
            String description = b.readLine();
            System.out.println("Price ");
            String price = b.readLine();
            Product p = new Product();
            p.setProductName(ProductName);
            p.setProductID(ProductId);
            p.setDescription(description);
            p.setPrice(Integer.parseInt(price));
            c.products.add(p);
            return add;

        }

        public ArrayList<Category> deleteCategory(ArrayList<Category> c, String id) {
            int delid = Integer.parseInt(id);
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getCategoryID() == delid) {
                    c.remove(i);
                    break;
                }
            }
            return c;
        }

        public ArrayList<Category> addProduct(ArrayList<Category> categories, String cid, String ProductId, String ProductName, String price, String des) {
            Product p = new Product();
            p.setPrice(Integer.parseInt(price));
            p.setProductName(ProductName);
            p.setProductID(ProductId);
            p.setDescription(des);
            for (int i = 0; i < categories.size(); i++) {
                if (Integer.parseInt(cid) == categories.get(i).getCategoryID()) {
                    categories.get(i).products.add(p);
                    break;
                }
            }
            return categories;


        }

        public ArrayList<Category> deleteProduct(ArrayList<Category> categories, String catid, String prid) {
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getCategoryID() == Integer.parseInt(catid)) {
                    for (int k = 0; k < categories.get(i).products.size(); k++) {
                        if (categories.get(i).products.get(k).getProductId().equals(prid)) {
                            categories.get(i).products.remove(k);
                            break;
                        }
                    }
                    break;
                }
            }
            return categories;
        }

        public ArrayList<Product> addDiscount(Portal p) throws IOException {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter thre product id ");
            String id = b.readLine();
            String elite = b.readLine();
            String prime = b.readLine();
            String normal = b.readLine();
            ArrayList<Category> getList = new ArrayList<>();
            ArrayList<Product> pr = new ArrayList<>();

            for (int i = 0; i < getList.size(); i++) {
                pr = getList.get(i).products;
                for (int j = 0; j < pr.size(); j++) {
                    if (pr.get(i).getProductId().equals(id)) {
                        pr.get(i).setEliteDiscount(elite);
                        pr.get(i).setPrimeDiscount(prime);
                        pr.get(i).setNormalDiscount(normal);
                        break;
                    }

                }
            }
            return pr;


        }

        public ArrayList<Category> setDiscount(ArrayList<Category> categories, String id, String elite, String prime, String normal) {
            for (int i=0;i<categories.size();i++){
                for(int j=0;j<categories.get(i).products.size();j++){
                    if(categories.get(i).products.get(j).getProductId().equals(id)){
                        categories.get(i).products.get(j).setEliteDiscount(elite);
                        categories.get(i).products.get(j).setPrimeDiscount(prime);
                        categories.get(i).products.get(j).setNormalDiscount(normal);
                        break;
                    }
                }
            }
            return categories;
        }
        public ArrayList<Product> deal(ArrayList<Product> c,String a,String b,String price){

            String name="Product " + a+ " "+b +"will together"+price;
            Product p=new Product();
            p.setProductName(name);
            p.setPrice(Integer.parseInt(price));
            c.add(p);
            return  c;
        }

    }
    class Product extends Category{
        private String productID;
        private String productName;
        private String description;
        private int price;
        private String eliteDiscount;
        private String primeDiscount;
        private String normalDiscount;

        public void setEliteDiscount(String elite){
            this.eliteDiscount=elite;
        }
        public String getEliteDiscount(){
            return this.eliteDiscount;
        }
        public void setPrimeDiscount(String prime){
            this.primeDiscount=prime;
        }
        public String getPrimeDiscount(){
            return this.primeDiscount;
        }
        public void setNormalDiscount(String normal){
            this.normalDiscount=normal;

        }
        public String getNormalDiscount(){
            return  this.normalDiscount;
        }
        public void setProductID(String id){
            this.productID=id;
        }
        public void setProductName(String productName){
            this.productName=productName;
        }
        public void setDescription(String description){
            this.description=description;
        }
        public String getProductId(){
            return this.productID;
        }
        public String getProductName(){
            return this.productName;
        }
        public String getProductDescription(){
            return this.description;
        }
        public void setPrice(int price){
            this.price=price;
        }
        public int getPrice(){
            return this.price;
        }




    }
    public class Main {

        public static void main(String[] args) throws Exception {
            Scanner s=new Scanner(System.in);
            String enter=s.nextLine();
            Portal p=new Portal();
            p.menue();
        }
    }

