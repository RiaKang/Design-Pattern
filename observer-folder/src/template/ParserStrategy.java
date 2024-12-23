package template;

public interface ParserStrategy<T> {
    public T parse(String line);
}
