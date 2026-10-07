package books;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String context) {
        System.out.println("Paragraph: # Align Right " + paragraph.getText());
    }
}