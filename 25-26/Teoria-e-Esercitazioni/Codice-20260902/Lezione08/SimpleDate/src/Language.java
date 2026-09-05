public enum Language {
    IT, US;
    public String toString() {
        switch (this) {
            case IT: return "italiano";
            case US: return "american";
            default: return null;
        }
    }
}
