package com.healthcarecenter.utils;

import com.healthcarecenter.models.HealthTipsProveider;
import java.util.ArrayList;
import java.util.Random;

public class HealthTips extends HealthTipsProveider{  

    @Override
    public String getRandomTipForDoctor() {
        ArrayList<String> tips;
        tips = new ArrayList<>();

        tips.add("Stay current with medical research and advancements.");
        tips.add("Practice empathy and active listening with patients.");
        tips.add("Prioritize self-care to prevent burnout.");
        tips.add("Maintain clear and thorough patient records.");
        tips.add("Continuously improve communication skills.");
        tips.add("Stay organized with a reliable scheduling system.");
        tips.add("Engage in professional networking and collaborations.");
        tips.add("Seek feedback from colleagues and patients.");
        tips.add("Stay up-to-date with medical ethics and guidelines.");
        tips.add("Participate in continuing medical education (CME) programs.");
        tips.add("Stay aware of and address mental health concerns in patients.");
        tips.add("Encourage a team-based approach to patient care.");
        tips.add("Utilize technology to streamline administrative tasks.");
        tips.add("Be proactive in preventing medical errors.");
        tips.add("Practice cultural competence and sensitivity.");
        tips.add("Maintain a healthy work-life balance.");
        tips.add("Stay informed about health policy and advocacy.");
        tips.add("Participate in community health initiatives.");
        tips.add("Foster a positive and supportive work environment.");
        tips.add("Always verify patient information and allergies.");
        tips.add("Keep emergency contact information readily available.");
        tips.add("Encourage preventive care and regular check-ups.");
        tips.add("Be open to new treatment methods and techniques.");
        tips.add("Maintain a clean and safe clinical environment.");
        tips.add("Communicate clearly about treatment plans and options.");
        tips.add("Encourage patient education and self-management.");
        tips.add("Respect patient confidentiality and privacy.");
        tips.add("Be mindful of time management in clinical settings.");
        tips.add("Promote a healthy lifestyle for both patients and staff.");
        tips.add("Develop a strong mentor-mentee relationship.");
        tips.add("Practice mindfulness and stress-reduction techniques.");
        tips.add("Stay informed about global health trends.");
        tips.add("Encourage collaboration among healthcare providers.");
        tips.add("Be adaptable and open to change in the medical field.");
        tips.add("Maintain professional boundaries with patients.");
        tips.add("Ensure proper follow-up on patient care plans.");
        tips.add("Use evidence-based practices in medical decision-making.");
        tips.add("Take time for regular exercise and physical activity.");
        tips.add("Foster patient trust and build rapport.");
        tips.add("Stay vigilant about patient safety and infection control.");
        tips.add("Promote teamwork and collaboration in healthcare settings.");
        tips.add("Continuously improve diagnostic skills.");
        tips.add("Be aware of and address healthcare disparities.");
        tips.add("Encourage patient participation in clinical trials.");
        tips.add("Be an advocate for patient rights and autonomy.");
        tips.add("Utilize telemedicine to expand access to care.");
        tips.add("Stay prepared for medical emergencies and disasters.");
        tips.add("Encourage a holistic approach to patient care.");
        tips.add("Stay involved in medical research and publications.");
        tips.add("Promote health literacy and education in the community.");
        tips.add("Maintain a positive and approachable demeanor.");
        tips.add("Develop strong leadership and management skills.");
        tips.add("Encourage open and honest communication within the healthcare team.");
        tips.add("Stay up-to-date with advancements in medical technology.");
        tips.add("Be proactive in addressing public health concerns.");
        tips.add("Foster a culture of continuous learning and improvement.");

        Random random = new Random();
        int index = random.nextInt(tips.size());
        return tips.get(index);

    }
}
