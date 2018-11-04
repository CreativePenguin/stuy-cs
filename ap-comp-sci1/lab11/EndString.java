public class EndString {
    private boolean endsWith(String str, String suffix) {
        return str.substring(
                str.length() - suffix.length()
            ).equals(suffix);
    }
}
