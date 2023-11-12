public class GetSpecificTags {
    public static String getTags(String input) {
        return execute(input);
    }

    private static String execute(String input) {
        if(input.startsWith("  <tag")){
            return input;
        }
        return null;
    }
}