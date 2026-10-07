package books;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String context) {
        System.out.println("Paragraph: # Align Center " + paragraph.getText() + " #");
    }
}