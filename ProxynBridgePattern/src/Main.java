//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProxyImage img1 = new ProxyImage("GUEST" , "photo.png");
        ProxyImage img2 = new ProxyImage("ADMIN" , "photo.png");
        img1.show();
        img2.show();

    }
}