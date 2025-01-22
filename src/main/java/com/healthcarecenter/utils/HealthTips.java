package com.healthcarecenter.utils;
import java.util.ArrayList;
import java.util.Random;

public class HealthTips {

public String getRandomHealthTip() {
ArrayList<String> tips;
tips = new ArrayList<>();
        
		tips.add("Drink plenty of water throughout the day.");
        tips.add("Exercise for at least 30 minutes a day.");
        tips.add("Eat a balanced diet with plenty of fruits and vegetables.");
        tips.add("Get at least 7-9 hours of sleep every night.");
        tips.add("Practice mindfulness or meditation to reduce stress.");
        tips.add("Avoid smoking and excessive alcohol consumption.");
        tips.add("Wash your hands frequently to prevent illness.");
        tips.add("Maintain a healthy weight for your body type.");
        tips.add("Limit your intake of processed and sugary foods.");
        tips.add("Get regular health check-ups with your doctor.");
        tips.add("Always wear sunscreen to protect your skin from UV rays.");
        tips.add("Take breaks during long periods of sitting or working.");
        tips.add("Avoid excessive caffeine and opt for herbal teas.");
        tips.add("Engage in social activities to boost mental health.");
        tips.add("Take deep breaths to calm down when you're feeling anxious.");
        tips.add("Practice good posture to prevent back pain.");
        tips.add("Consume healthy fats, like avocados and olive oil.");
        tips.add("Ensure you get enough calcium for strong bones.");
        tips.add("Don't skip meals, especially breakfast.");
        tips.add("Limit your screen time to reduce eye strain.");
        tips.add("Stay hydrated by drinking water instead of sugary drinks.");
        tips.add("Try to incorporate more plant-based meals into your diet.");
        tips.add("Take a walk outside to get fresh air and sunlight.");
        tips.add("Avoid overeating by eating smaller, more frequent meals.");
        tips.add("Try yoga or stretching exercises for flexibility.");
        tips.add("Consider adding a probiotic to your diet for gut health.");
        tips.add("Limit your salt intake to maintain healthy blood pressure.");
        tips.add("Include fiber-rich foods to aid digestion.");
        tips.add("Take care of your mental health as much as your physical health.");
        tips.add("Avoid late-night snacking to improve sleep quality.");
        tips.add("Drink green tea for its antioxidants and metabolism-boosting properties.");
        tips.add("Chew your food slowly to aid digestion.");
        tips.add("Take the stairs instead of the elevator for extra activity.");
        tips.add("Engage in strength training exercises to build muscle mass.");
        tips.add("Cut down on refined sugars to prevent spikes in blood sugar.");
        tips.add("Prioritize your mental health by seeking help when needed.");
        tips.add("Keep your environment clean and free of allergens.");
        tips.add("Avoid sitting for long periods to improve circulation.");
        tips.add("Add more omega-3 fatty acids to your diet, found in fish and flaxseeds.");
        tips.add("Don’t skip stretching before and after workouts.");
        tips.add("Try to keep a positive mindset for better overall well-being.");
        tips.add("Listen to your body and rest when you feel tired.");
        tips.add("Avoid excessive use of medications without consulting a doctor.");
        tips.add("Stay active with hobbies like gardening or dancing.");
        tips.add("Avoid heavy meals right before bedtime.");
        tips.add("Consider journaling as a way to manage stress and emotions.");
        tips.add("Maintain healthy relationships for emotional support.");
        tips.add("Be mindful of your sugar intake to prevent long-term health problems.");
        tips.add("Take time to relax and unwind, especially after stressful days.");
        tips.add("Wash your face regularly to avoid breakouts.");
        tips.add("Include more whole grains in your diet for sustained energy.");
        tips.add("Opt for natural skincare products to avoid harmful chemicals.");
        tips.add("Get vaccinated to protect yourself and others from illness.");
        tips.add("Enjoy outdoor activities to boost your mood and physical health.");
        tips.add("Incorporate mindfulness into your daily routine.");
        tips.add("Practice gratitude to improve mental well-being.");
        tips.add("Get into the habit of eating at regular intervals.");
        tips.add("Stay consistent with your exercise routine for better results.");
        tips.add("Avoid multitasking, as it can affect your productivity and mental health.");
        
		
		Random random = new Random();
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}
