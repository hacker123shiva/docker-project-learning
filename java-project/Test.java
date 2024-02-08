class Test {

    public static void printSystemProperties() {
        System.out.println("properties of my system are: ");
        System.out.println(System.getProperties());
    }

    public static void main(String[] args) {
        System.out.println("Java Program started... ");
        printSystemProperties();
    }
}