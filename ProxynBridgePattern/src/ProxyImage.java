public class ProxyImage {
    String userRole;
    String fileName;
    public ProxyImage(String userRole, String fileName){
        this.userRole = userRole;
        this.fileName = fileName;
    }
    public void show(){
        if(userRole!="ADMIN"){
            System.out.println("[ACCESS DENIED] You lack permission to view: "+ fileName+ ". ");
            return;
        }
        else {
            System.out.println("--> [SLOW] Reading salary_sheet.png from hard drive...\n" +
                    "Displaying " +fileName+" on screen!");
        }


    }
}
