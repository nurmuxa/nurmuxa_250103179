public class ProxyVideo {
    private int viewCount = 0;
    String videoName;
    public ProxyVideo(String videoName){
        this.videoName = videoName;
    }

    public void play(){
        viewCount++;
        System.out.println("[AUDIT] Video has been played " +viewCount+ " time(s)");
    }

}
