public class new11 {
    public static void main(String[] args) {
    String s="http://sysadmin:123456@10.15.15.89:8090/ demo/testWar.git";
        System.out.println(fun(s));
    }
    public static   String fun(String s)
    {
        String f1[]=s.split("@");
        String f2[]=f1[0].split("//");
        String fin=f2[0]+"//"+f1[1];
        return fin;
    }
}
