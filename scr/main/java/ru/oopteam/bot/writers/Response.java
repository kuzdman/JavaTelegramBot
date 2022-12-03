package ru.oopteam.bot.writers;

public class Response {
    private final String answer;
    private final Long userID;

    // Console bot constructor
    public Response(String answer) {
        this.answer = answer;
        this.userID = null;
    }

    // Telegram bot constructor
    public Response(String answer, Long userID) {
        this.answer = answer;
        this.userID = userID;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getUserID() {
        return userID;
    }
}
