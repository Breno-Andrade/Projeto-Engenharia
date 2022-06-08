import menus.MenuPrincipal;

public class App {
    public static void main(String[] args) throws Exception {
        MenuPrincipal menu = new MenuPrincipal(0);
        menu.exibeMenu();
        menu.verificaOpcao();      
    }
}
