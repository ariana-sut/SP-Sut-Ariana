package books;

public class BookStatistics implements Visitor {
    private int numberOfImages = 0;
    private int numberOfTables = 0;
    private int numberOfParagraphs = 0;

    @Override
    public void visitBook(Book book) {}

    @Override
    public void visitSection(Section section) {}

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {}

    @Override
    public void visitParagraph(Paragraph paragraph) {
        numberOfParagraphs++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        numberOfImages++;
    }

    @Override
    public void visitImage(Image image) {
        numberOfImages++;
    }

    @Override
    public void visitTable(BookTable table) {
        numberOfTables++;
    }

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + numberOfImages);
        System.out.println("*** Number of tables: " + numberOfTables);
        System.out.println("*** Number of paragraphs: " + numberOfParagraphs);
    }
}