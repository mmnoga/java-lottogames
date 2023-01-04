package pl.minigames.lotto;

record ValidationResult(boolean isValid, String message) {

    public boolean isNotValid() {
        return !isValid;
    }
}
