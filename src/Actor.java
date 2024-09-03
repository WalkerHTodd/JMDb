
public class Actor {

    private String name;
    private String id;
    private String image;
    private String charecter;

    public Actor(String name, String id, String image, String charecter) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.charecter = charecter;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getCharecter() {
        return charecter;
    }
}
