import java.util.HashMap;
import java.util.Map;

public class SimpleChatbot {

    private Map<String, String> knowledgeBase;

    public SimpleChatbot() {
        knowledgeBase = new HashMap<>();
        knowledgeBase.put("hi", "Hello! How can I assist you today?");
        knowledgeBase.put("hello", "Greetings! Ask me anything about our services.");
        knowledgeBase.put("how are you", "I am a bot, operating perfectly. How about you?");
        knowledgeBase.put("what is your name", "I am AlphaBot, your helpful rule-based assistant.");
        knowledgeBase.put("what services do you offer", "We offer programming courses, consulting, and project development.");
        knowledgeBase.put("where are you located", "Our operations are global, serving clients virtually.");
        knowledgeBase.put("bye", "Goodbye! Have a great day.");
    }


    public String getResponse(String input) {

        
        String cleanedInput = input.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();

        // 1. Exact Match Rule
        if (knowledgeBase.containsKey(cleanedInput)) {
            return knowledgeBase.get(cleanedInput);
        }

        // 2. Keyword/Partial Match Rules (Simulated Intent)
        if (cleanedInput.contains("services") || cleanedInput.contains("offer")) {
            return knowledgeBase.get("what services do you offer");
        } else if (cleanedInput.contains("location") || cleanedInput.contains("located")) {
            return knowledgeBase.get("where are you located");
        } else if (cleanedInput.contains("java") || cleanedInput.contains("programming")) {
            return "Java programming is one of our specialties. What specific question do you have?";
        } else if (cleanedInput.contains("thanks") || cleanedInput.contains("thank you")) {
            return "You're very welcome! Is there anything else I can help with?";
        }
        
        // 3. Default Fallback
        return "I'm sorry, I don't have an answer for that yet. Can you rephrase or ask a different question?";
    }
}