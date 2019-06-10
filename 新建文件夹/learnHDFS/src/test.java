public class test {

    public static void main(String[] args) {
        String a1="1",a2="1";
        String a3=a2;
        System.out.println(a1.hashCode());
        System.out.println(a3.hashCode());
        System.out.println(a1.hashCode()==a3.hashCode());
        System.out.println(a1.equals(a3));
    }
}
