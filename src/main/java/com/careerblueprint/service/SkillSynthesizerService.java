package com.careerblueprint.service;

import com.careerblueprint.enums.SkillCategory;
import com.careerblueprint.model.Identity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SkillSynthesizerService {

    private final Map<String, SkillCategory> skillDatabase = new HashMap<>();
    private final Map<String, Identity> identityCombinations = new HashMap<>();

    public SkillSynthesizerService() {
        initializeSkillDatabase();
        initializeIdentityCombinations();
    }

    private void initializeSkillDatabase() {
        // WRITING category
        skillDatabase.put("Menulis", SkillCategory.WRITING);
        skillDatabase.put("Copywriting", SkillCategory.WRITING);
        skillDatabase.put("Content Writing", SkillCategory.WRITING);
        skillDatabase.put("Blogging", SkillCategory.WRITING);
        skillDatabase.put("SEO Writing", SkillCategory.WRITING);
        skillDatabase.put("Technical Writing", SkillCategory.WRITING);
        skillDatabase.put("Scriptwriting", SkillCategory.WRITING);
        skillDatabase.put("Storytelling", SkillCategory.WRITING);
        skillDatabase.put("Journalism", SkillCategory.WRITING);
        skillDatabase.put("Ghostwriting", SkillCategory.WRITING);
        skillDatabase.put("Editing", SkillCategory.WRITING);
        skillDatabase.put("Proofreading", SkillCategory.WRITING);
        skillDatabase.put("Creative Writing", SkillCategory.WRITING);

        // TECHNICAL category
        skillDatabase.put("Coding", SkillCategory.TECHNICAL);
        skillDatabase.put("Programming", SkillCategory.TECHNICAL);
        skillDatabase.put("Web Development", SkillCategory.TECHNICAL);
        skillDatabase.put("Mobile Development", SkillCategory.TECHNICAL);
        skillDatabase.put("Database Management", SkillCategory.TECHNICAL);
        skillDatabase.put("Cloud Computing", SkillCategory.TECHNICAL);
        skillDatabase.put("DevOps", SkillCategory.TECHNICAL);
        skillDatabase.put("Cybersecurity", SkillCategory.TECHNICAL);
        skillDatabase.put("API Development", SkillCategory.TECHNICAL);
        skillDatabase.put("Machine Learning", SkillCategory.TECHNICAL);
        skillDatabase.put("Blockchain", SkillCategory.TECHNICAL);
        skillDatabase.put("IoT", SkillCategory.TECHNICAL);
        skillDatabase.put("Automation", SkillCategory.TECHNICAL);

        // VISUAL category
        skillDatabase.put("Graphic Design", SkillCategory.VISUAL);
        skillDatabase.put("Photography", SkillCategory.VISUAL);
        skillDatabase.put("Videography", SkillCategory.VISUAL);
        skillDatabase.put("Video Editing", SkillCategory.VISUAL);
        skillDatabase.put("UI Design", SkillCategory.VISUAL);
        skillDatabase.put("UX Design", SkillCategory.VISUAL);
        skillDatabase.put("Illustration", SkillCategory.VISUAL);
        skillDatabase.put("Motion Graphics", SkillCategory.VISUAL);
        skillDatabase.put("3D Modeling", SkillCategory.VISUAL);
        skillDatabase.put("Animation", SkillCategory.VISUAL);
        skillDatabase.put("Color Theory", SkillCategory.VISUAL);
        skillDatabase.put("Typography", SkillCategory.VISUAL);

        // INTERPERSONAL category
        skillDatabase.put("Public Speaking", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Negotiation", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Conflict Resolution", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Networking", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Active Listening", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Empathy", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Leadership", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Team Collaboration", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Mentoring", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Coaching", SkillCategory.INTERPERSONAL);
        skillDatabase.put("Persuasion", SkillCategory.INTERPERSONAL);

        // ANALYTICAL category
        skillDatabase.put("Excel", SkillCategory.ANALYTICAL);
        skillDatabase.put("Data Analysis", SkillCategory.ANALYTICAL);
        skillDatabase.put("Data Visualization", SkillCategory.ANALYTICAL);
        skillDatabase.put("Statistics", SkillCategory.ANALYTICAL);
        skillDatabase.put("Research", SkillCategory.ANALYTICAL);
        skillDatabase.put("Critical Thinking", SkillCategory.ANALYTICAL);
        skillDatabase.put("Problem Solving", SkillCategory.ANALYTICAL);
        skillDatabase.put("SQL", SkillCategory.ANALYTICAL);
        skillDatabase.put("Python", SkillCategory.ANALYTICAL);
        skillDatabase.put("R Programming", SkillCategory.ANALYTICAL);
        skillDatabase.put("Tableau", SkillCategory.ANALYTICAL);
        skillDatabase.put("Power BI", SkillCategory.ANALYTICAL);

        // MANAGEMENT category
        skillDatabase.put("Project Management", SkillCategory.MANAGEMENT);
        skillDatabase.put("Team Management", SkillCategory.MANAGEMENT);
        skillDatabase.put("Strategic Planning", SkillCategory.MANAGEMENT);
        skillDatabase.put("Risk Management", SkillCategory.MANAGEMENT);
        skillDatabase.put("Budgeting", SkillCategory.MANAGEMENT);
        skillDatabase.put("Resource Allocation", SkillCategory.MANAGEMENT);
        skillDatabase.put("Agile Methodology", SkillCategory.MANAGEMENT);
        skillDatabase.put("Scrum", SkillCategory.MANAGEMENT);
        skillDatabase.put("Change Management", SkillCategory.MANAGEMENT);
        skillDatabase.put("Operations Management", SkillCategory.MANAGEMENT);
        skillDatabase.put("Quality Assurance", SkillCategory.MANAGEMENT);

        // SALES category
        skillDatabase.put("Sales", SkillCategory.SALES);
        skillDatabase.put("Cold Calling", SkillCategory.SALES);
        skillDatabase.put("Lead Generation", SkillCategory.SALES);
        skillDatabase.put("CRM Management", SkillCategory.SALES);
        skillDatabase.put("B2B Sales", SkillCategory.SALES);
        skillDatabase.put("B2C Sales", SkillCategory.SALES);
        skillDatabase.put("Account Management", SkillCategory.SALES);
        skillDatabase.put("Closing", SkillCategory.SALES);

        // TEACHING category
        skillDatabase.put("Teaching", SkillCategory.TEACHING);
        skillDatabase.put("Training", SkillCategory.TEACHING);
        skillDatabase.put("Curriculum Design", SkillCategory.TEACHING);
        skillDatabase.put("Instructional Design", SkillCategory.TEACHING);
        skillDatabase.put("Facilitation", SkillCategory.TEACHING);
        skillDatabase.put("E-Learning", SkillCategory.TEACHING);
        skillDatabase.put("Public Training", SkillCategory.TEACHING);

        // COOKING category
        skillDatabase.put("Cooking", SkillCategory.COOKING);
        skillDatabase.put("Baking", SkillCategory.COOKING);
        skillDatabase.put("Culinary Arts", SkillCategory.COOKING);
        skillDatabase.put("Food Plating", SkillCategory.COOKING);
        skillDatabase.put("Menu Planning", SkillCategory.COOKING);
        skillDatabase.put("Food Safety", SkillCategory.COOKING);

        // MUSIC category
        skillDatabase.put("Music Production", SkillCategory.MUSIC);
        skillDatabase.put("Audio Engineering", SkillCategory.MUSIC);
        skillDatabase.put("Sound Design", SkillCategory.MUSIC);
        skillDatabase.put("Mixing", SkillCategory.MUSIC);
        skillDatabase.put("Mastering", SkillCategory.MUSIC);
        skillDatabase.put("Music Composition", SkillCategory.MUSIC);

        // FINANCE category
        skillDatabase.put("Accounting", SkillCategory.FINANCE);
        skillDatabase.put("Financial Analysis", SkillCategory.FINANCE);
        skillDatabase.put("Investment", SkillCategory.FINANCE);
        skillDatabase.put("Tax Planning", SkillCategory.FINANCE);
        skillDatabase.put("Auditing", SkillCategory.FINANCE);
        skillDatabase.put("Financial Modeling", SkillCategory.FINANCE);

        // MARKETING category
        skillDatabase.put("Digital Marketing", SkillCategory.MARKETING);
        skillDatabase.put("Social Media Marketing", SkillCategory.MARKETING);
        skillDatabase.put("Email Marketing", SkillCategory.MARKETING);
        skillDatabase.put("Content Marketing", SkillCategory.MARKETING);
        skillDatabase.put("Brand Strategy", SkillCategory.MARKETING);
        skillDatabase.put("Market Research", SkillCategory.MARKETING);
        skillDatabase.put("SEO", SkillCategory.MARKETING);
        skillDatabase.put("SEM", SkillCategory.MARKETING);

        // DESIGN category
        skillDatabase.put("Interior Design", SkillCategory.DESIGN);
        skillDatabase.put("Fashion Design", SkillCategory.DESIGN);
        skillDatabase.put("Product Design", SkillCategory.DESIGN);
        skillDatabase.put("Industrial Design", SkillCategory.DESIGN);
        skillDatabase.put("Architectural Design", SkillCategory.DESIGN);

        // OPERATIONS category
        skillDatabase.put("Supply Chain", SkillCategory.OPERATIONS);
        skillDatabase.put("Logistics", SkillCategory.OPERATIONS);
        skillDatabase.put("Inventory Management", SkillCategory.OPERATIONS);
        skillDatabase.put("Process Optimization", SkillCategory.OPERATIONS);
        skillDatabase.put("Lean Manufacturing", SkillCategory.OPERATIONS);
        skillDatabase.put("Six Sigma", SkillCategory.OPERATIONS);
    }

    public Map<String, String> getSkillDatabase() {
        Map<String, String> result = new HashMap<>();
        skillDatabase.forEach((skill, category) -> result.put(skill, category.name()));
        return result;
    }

    private void initializeIdentityCombinations() {
        // 2-Category Combinations (60 combinations)
        // WRITING + X combinations
        identityCombinations.put("WRITING+TECHNICAL", createIdentity("Technical Documentalist",
            "Kamu adalah penjembat antara kompleksitas teknologi dan kebutuhan manusia akan pemahaman. Keahlian menulismu membuat sistem yang rumit menjadi aksesibel, sementara latar belakang teknismu memastikan akurasi. Di era transformasi digital, peranmu tidak tergantikan.",
            Arrays.asList("API Documentation Specialist", "Technical Writing Consultant", "SaaS Documentation Lead")));

        identityCombinations.put("WRITING+VISUAL", createIdentity("Visual Storyteller",
            "Kamu melihat dunia sebagai kanvas naratif. Kombinasi tulisan dan visual memungkinkanmu menciptakan pengalaman imersif yang tidak hanya dilihat, tetapi juga dirasakan. Setiap proyekmu adalah karya seni yang berbicara langsung ke hati audiens.",
            Arrays.asList("Brand Storytelling Consultant", "Creative Director", "Content Strategist")));

        identityCombinations.put("WRITING+INTERPERSONAL", createIdentity("Conversion Copywriter",
            "Kamu mengerti bahwa kata-kata adalah jembatan emosional. Kemampuanmu memahami manusia dan mengubahnya menjadi tulisan yang menggugat adalah keahlian langka. Setiap copy yang kamu tulis tidak sekadar informasi, tetapi dorongan untuk bertindak.",
            Arrays.asList("Direct Response Copywriter", "Sales Page Specialist", "Email Marketing Expert")));

        identityCombinations.put("WRITING+ANALYTICAL", createIdentity("Algorithm Auditor",
            "Kamu adalah detektif data yang mampu menjelaskan temuan kompleks dengan bahasa yang manusiawi. Di dunia yang dipenuhi algoritma, kemampuanmu menganalisis dan mengkomunikasikan adalah kompas moral teknologi.",
            Arrays.asList("AI Ethics Writer", "Data Storyteller", "Research Communicator")));

        identityCombinations.put("WRITING+MANAGEMENT", createIdentity("Editorial Operations Director",
            "Kamu melihat konten sebagai sistem, bukan sekadar kata-kata terpisah. Kemampuanmu mengelola tim kreatif sambil menjaga standar editorial menjadikanmu arsitek behind-the-scenes publishing yang sukses.",
            Arrays.asList("Content Operations Manager", "Editorial Director", "Publishing Consultant")));

        identityCombinations.put("WRITING+SALES", createIdentity("Sales Copy Architect",
            "Kamu membangun jembatan antara produk dan keputusan pembelian melalui kata-kata yang terstruktur dengan sempurna. Setiap landing page adalah konstruksi persuasi yang kamu rancang dengan presisi.",
            Arrays.asList("High-Ticket Copywriter", "Launch Copy Specialist", "Sales Funnel Writer")));

        identityCombinations.put("WRITING+TEACHING", createIdentity("Curriculum Writer",
            "Kamu adalah arsitek pembelajaran. Kemampuanmu merancang pengalaman belajar yang jelas dan menarik memungkinkanmu menciptakan dampak skala besar pada ribuan siswa.",
            Arrays.asList("Instructional Designer", "Course Creator", "EdTech Content Lead")));

        identityCombinations.put("WRITING+FINANCE", createIdentity("Financial Communicator",
            "Kamu menerjemahkan bahasa alien keuangan menjadi cerita yang dimengerti orang biasa. Di dunia fintech yang berkembang, peranmu adalah jembatan antara institusi dan individu.",
            Arrays.asList("Fintech Content Lead", "Investment Writer", "Financial Educator")));

        identityCombinations.put("WRITING+MARKETING", createIdentity("Content Marketing Strategist",
            "Kamu mengerti bahwa konten adalah investasi jangka panjang. Kemampuanmu menciptakan aset tulisan yang menjual 24/7 menjadikanmu partner strategis bagi brand yang cerdas.",
            Arrays.asList("SEO Content Director", "Inbound Marketing Lead", "Thought Leadership Writer")));

        identityCombinations.put("WRITING+DESIGN", createIdentity("Design Writer",
            "Kamu adalah pemberi suara pada karya visual. Kemampuanmu menjelaskan dan mempromosikan desain membuatmu menjadi partner tak tergantikan bagi desainer dan agency.",
            Arrays.asList("Design Critique Writer", "Portfolio Storyteller", "Creative Agency Copywriter")));

        // TECHNICAL + X combinations
        identityCombinations.put("TECHNICAL+VISUAL", createIdentity("Creative Technologist",
            "Kamu berada di persimpangan kode dan kanvas. Kemampuanmu memadukan logika pemrograman dengan estetika visual menjadikanmu arsitek pengalaman digital yang langka dan dicari.",
            Arrays.asList("Creative Developer", "Interactive Media Engineer", "Generative Art Programmer")));

        identityCombinations.put("TECHNICAL+INTERPERSONAL", createIdentity("Developer Relations Specialist",
            "Kamu adalah diplomat teknologi. Kemampuanmu menjembatani dunia teknis dengan komunitas membuatmu menjadi wajah dan suara platform yang dicintai developer.",
            Arrays.asList("DevRel Engineer", "Technical Community Manager", "API Evangelist")));

        identityCombinations.put("TECHNICAL+ANALYTICAL", createIdentity("Data Engineer",
            "Kamu adalah arsitek infrastruktur wawasan. Di era data, kemampuanmu membangun sistem yang mengubah kekacauan menjadi kejelasan adalah fondasi keputusan bisnis.",
            Arrays.asList("Data Platform Engineer", "Analytics Engineer", "BI Developer")));

        identityCombinations.put("TECHNICAL+MANAGEMENT", createIdentity("Engineering Manager",
            "Kamu memimpin dengan pemahaman teknis yang mendalam. Tim di bawah kepemimpinanmu tidak hanya produktif, tetapi juga tumbuh karena kamu mengerti pekerjaan mereka.",
            Arrays.asList("Tech Lead", "VP of Engineering", "CTO")));

        identityCombinations.put("TECHNICAL+SALES", createIdentity("Solutions Engineer",
            "Kamu menjual dengan bukti, bukan janji. Kemampuanmu mendemonstrasikan solusi teknis mempersingkat siklus penjualan dan meningkatkan closing rate secara dramatis.",
            Arrays.asList("Sales Engineer", "Solutions Architect", "Technical Account Manager")));

        identityCombinations.put("TECHNICAL+TEACHING", createIdentity("Technical Educator",
            "Kamu menerjemahkan bahasa mesin menjadi bahasa manusia. Setiap course yang kamu buat membuka pintu bagi ribuan orang untuk memasuki industri teknologi.",
            Arrays.asList("Bootcamp Instructor", "Developer Advocate", "Technical Course Creator")));

        identityCombinations.put("TECHNICAL+COOKING", createIdentity("Cloud Kitchen Systems Designer",
            "Kamu membangun sistem efisiensi untuk revolusi kuliner digital. Kombinasi teknologi dan pemahaman operasional dapur membuatmu arsitek bisnis F&B masa depan.",
            Arrays.asList("Kitchen Tech Consultant", "Food Delivery Systems Architect", "Restaurant Tech Founder")));

        identityCombinations.put("TECHNICAL+MUSIC", createIdentity("Audio Software Engineer",
            "Kamu membangun alat yang digunakan musisi untuk menciptakan. Di persimpangan passion dan profit, kamu memungkinkan kreativitas tanpa batas.",
            Arrays.asList("DAW Developer", "Audio Plugin Engineer", "Music Tech Founder")));

        identityCombinations.put("TECHNICAL+FINANCE", createIdentity("Quantitative Developer",
            "Kamu adalah arsitek sistem perdagangan modern. Kemampuanmu menggabungkan logika pemrograman dengan mekanisme pasar membuatmu pemain kunci di institusi finansial.",
            Arrays.asList("Trading Systems Developer", "Fintech Engineer", "Blockchain Developer")));

        identityCombinations.put("TECHNICAL+MARKETING", createIdentity("Marketing Technologist",
            "Kamu membangun mesin pertumbuhan. Stack teknologi yang kamu rancang mengotomatisasi dan mengoptimalkan setiap titik sentuhan pelanggan.",
            Arrays.asList("Marketing Automation Engineer", "Growth Engineer", "MarTech Consultant")));

        identityCombinations.put("TECHNICAL+OPERATIONS", createIdentity("Operations Systems Architect",
            "Kamu membangun tulang punggung infrastruktur bisnis. Setiap sistem yang kamu rancang menghemat ribuan jam kerja manusia.",
            Arrays.asList("Systems Integration Engineer", "Process Automation Lead", "Digital Operations Manager")));

        // VISUAL + X combinations
        identityCombinations.put("VISUAL+INTERPERSONAL", createIdentity("Experiential Designer",
            "Kamu menciptakan momen yang tidak terlupakan. Kemampuanmu mendesain pengalaman yang beresonansi secara emosional menjadikanmu arsitek memori.",
            Arrays.asList("Event Experience Designer", "Brand Experience Consultant", "Immersive Designer")));

        identityCombinations.put("VISUAL+ANALYTICAL", createIdentity("Data Visualization Expert",
            "Kamu adalah penerjemah angka menjadi narasi visual. Di dunia yang kelebihan data, kemampuanmu membuat informasi menjadi actionable adalah keahlian emas.",
            Arrays.asList("Information Designer", "Data Artist", "Dashboard Designer")));

        identityCombinations.put("VISUAL+MANAGEMENT", createIdentity("Creative Operations Director",
            "Kamu memimpin dengan vision. Kemampuanmu mengelola tim kreatif sambil memastikan deliverable berkualitas menjadikanmu director yang dicari agency.",
            Arrays.asList("Design Ops Manager", "Studio Manager", "Creative Director")));

        identityCombinations.put("VISUAL+SALES", createIdentity("Visual Sales Strategist",
            "Kamu mengerti bahwa orang membeli dengan mata. Presentasi visualmu bukan sekadar cantik, tetapi dirancang untuk mengkonversi.",
            Arrays.asList("Sales Deck Designer", "Visual Pitch Consultant", "Presentation Specialist")));

        identityCombinations.put("VISUAL+TEACHING", createIdentity("Visual Educator",
            "Kamu membuat pembelajaran menjadi pengalaman visual. Setiap diagram, animasi, dan infografis yang kamu buat mengubah pemahaman kompleks menjadi aha moment.",
            Arrays.asList("Educational Illustrator", "Course Visual Designer", "Knowledge Visualization Expert")));

        identityCombinations.put("VISUAL+MUSIC", createIdentity("Visual Music Director",
            "Kamu mensinkronkan dua bahasa universal: gambar dan suara. Dari music video hingga live performance visual, kamu menciptakan sinergi sensasional.",
            Arrays.asList("Music Video Director", "Concert Visual Designer", "Audio-Visual Artist")));

        identityCombinations.put("VISUAL+FINANCE", createIdentity("Financial Visual Designer",
            "Kamu membuat keuangan menjadi mudah dicerna. Report dan dashboard yang kamu desain mengubah kecemasan menjadi kepercayaan diri.",
            Arrays.asList("Fintech UX Designer", "Financial Infographics Specialist", "Investment Report Designer")));

        identityCombinations.put("VISUAL+MARKETING", createIdentity("Brand Visual Strategist",
            "Kamu adalah penjaga identitas visual brand. Setiap aset yang kamu buat memperkuat positioning dan mempercepat pengenalan di pasar.",
            Arrays.asList("Brand Designer", "Visual Marketing Lead", "Creative Strategy Director")));

        identityCombinations.put("VISUAL+DESIGN", createIdentity("Multidisciplinary Designer",
            "Kamu melampaui batas disiplin desain. Dari digital hingga fisik, kemampuanmu beradaptasi menjadikanmu desainer yang tak terbatas media.",
            Arrays.asList("Design Generalist Consultant", "Creative Director", "Design System Architect")));

        identityCombinations.put("VISUAL+OPERATIONS", createIdentity("Visual Operations Designer",
            "Kamu membuat operasional menjadi terlihat dan teratur. Sistem visual yang kamu rancang mengurangi kesalahan dan meningkatkan efisiensi tim.",
            Arrays.asList("Operations Visual Systems Designer", "Workflow Visualization Expert", "Lean Visual Consultant")));

        // INTERPERSONAL + X combinations
        identityCombinations.put("INTERPERSONAL+ANALYTICAL", createIdentity("Research Interviewer",
            "Kamu menggali wawasan yang tersembunyi. Kemampuanmu membuat orang nyaman berbagi, dikombinasikan dengan analisis tajam, menghasilkan intelijen pasar yang berharga.",
            Arrays.asList("UX Researcher", "Qualitative Research Lead", "Customer Insight Specialist")));

        identityCombinations.put("INTERPERSONAL+MANAGEMENT", createIdentity("People Operations Lead",
            "Kamu adalah arsitek budaya kerja. Pemahamanmu terhadap manusia dan sistem memungkinkanmu menciptakan organisasi tempat talenta berkembang.",
            Arrays.asList("HR Director", "Chief People Officer", "Culture Consultant")));

        identityCombinations.put("INTERPERSONAL+SALES", createIdentity("Relationship Sales Expert",
            "Kamu tidak menjual produk, kamu membangun hubungan. Kepercayaan adalah mata uangmu, dan kamu kaya raya.",
            Arrays.asList("Enterprise Sales Executive", "Key Account Manager", "Partnership Director")));

        identityCombinations.put("INTERPERSONAL+TEACHING", createIdentity("Corporate Trainer",
            "Kamu adalah agen transformasi organisasi. Setiap sesi trainingmu mengubah perilaku dan meningkatkan performa tim.",
            Arrays.asList("Leadership Development Coach", "Organizational Trainer", "Soft Skills Facilitator")));

        identityCombinations.put("INTERPERSONAL+COOKING", createIdentity("Culinary Experience Host",
            "Kamu menciptakan momen di sekitar meja. Bukan sekadar makanan, tapi kenangan yang terbentuk melalui interaksi dan cita rasa.",
            Arrays.asList("Private Chef & Host", "Dining Experience Curator", "Food Tour Guide")));

        identityCombinations.put("INTERPERSONAL+MUSIC", createIdentity("Music Community Builder",
            "Kamu mengumpulkan orang di sekitar suara. Dari fan community hingga collaborative platforms, kamu menciptakan ekosistem di sekitar musik.",
            Arrays.asList("Artist Manager", "Music Community Manager", "Fan Engagement Specialist")));

        identityCombinations.put("INTERPERSONAL+FINANCE", createIdentity("Financial Advisor",
            "Kamu adalah teman pembicaraan keuangan. Kepercayaan yang kamu bangun memungkinkan klien membuat keputusan besar dengan percaya diri.",
            Arrays.asList("Wealth Manager", "Financial Planner", "Investment Consultant")));

        identityCombinations.put("INTERPERSONAL+MARKETING", createIdentity("Community Marketing Lead",
            "Kamu membangun hubungan yang menggerakkan bisnis. Komunitas yang kamu bangun bukan sekadar audience, tapi advokat.",
            Arrays.asList("Community Manager", "Brand Ambassador Lead", "Influencer Relations")));

        identityCombinations.put("INTERPERSONAL+OPERATIONS", createIdentity("Stakeholder Operations Manager",
            "Kamu menjaga semua pihak tetap terhubung dan terinformasi. Kemampuanmu mengelola ekspektasi beragam adalah lem yang menyatukan operasi.",
            Arrays.asList("Client Operations Manager", "Vendor Relations Lead", "Partnership Operations")));

        // ANALYTICAL + X combinations
        identityCombinations.put("ANALYTICAL+MANAGEMENT", createIdentity("Data-Driven Manager",
            "Kamu memimpin dengan bukti, bukan intuisi. Setiap keputusanmu didukung data, mengurangi risiko dan meningkatkan probabilitas sukses.",
            Arrays.asList("Analytics Manager", "Business Intelligence Director", "Performance Lead")));

        identityCombinations.put("ANALYTICAL+SALES", createIdentity("Sales Analyst",
            "Kamu menemukan pola dalam pipeline. Insight yang kamu hasilkan mengubah tim sales dari reaktif menjadi prediktif.",
            Arrays.asList("Sales Operations Analyst", "Revenue Analyst", "CRM Data Specialist")));

        identityCombinations.put("ANALYTICAL+TEACHING", createIdentity("Analytics Educator",
            "Kamu membuka dunia data bagi yang baru memulai. Setiap konsep yang kamu ajarkan adalah kunci untuk ribuan keputusan yang lebih baik.",
            Arrays.asList("Data Literacy Trainer", "Analytics Bootcamp Instructor", "Corporate Data Coach")));

        identityCombinations.put("ANALYTICAL+COOKING", createIdentity("Culinary Data Scientist",
            "Kamu mengoptimalkan seni memasak dengan sains. Dari cost analysis hingga flavor profiling, kamu membawa presisi ke kreativitas.",
            Arrays.asList("Menu Optimization Consultant", "Food Cost Analyst", "Culinary R&D Scientist")));

        identityCombinations.put("ANALYTICAL+MUSIC", createIdentity("Music Data Analyst",
            "Kamu menemukan apa yang membuat lagu viral. Di industri yang didorong data, insightmu membentuk strategi rilis dan pemasaran.",
            Arrays.asList("Streaming Data Analyst", "Music Trend Researcher", "A&R Data Specialist")));

        identityCombinations.put("ANALYTICAL+FINANCE", createIdentity("Financial Analyst",
            "Kamu adalah detektif neraca keuangan. Kemampuanmu menemukan cerita di balik angka membuatmu penasihat yang tak tergantikan.",
            Arrays.asList("Investment Analyst", "Corporate Finance Analyst", "Risk Analyst")));

        identityCombinations.put("ANALYTICAL+MARKETING", createIdentity("Growth Analyst",
            "Kamu menemukan celah pertumbuhan yang tersembunyi. Setiap funnel yang kamu optimalkan adalah jalur revenue baru.",
            Arrays.asList("Marketing Analyst", "Growth Marketing Manager", "Attribution Specialist")));

        identityCombinations.put("ANALYTICAL+DESIGN", createIdentity("Design Researcher",
            "Kamu membawa validasi ke proses kreatif. Data-driven designmu menghasilkan solusi yang tidak hanya cantik, tetapi juga efektif.",
            Arrays.asList("UX Research Lead", "Design Strategist", "Product Researcher")));

        identityCombinations.put("ANALYTICAL+OPERATIONS", createIdentity("Operations Analyst",
            "Kamu menemukan ineffisiensi yang tersembunyi. Setiap proses yang kamu optimalkan menghemat biaya dan mempercepat delivery.",
            Arrays.asList("Process Analyst", "Operations Research Analyst", "Continuous Improvement Lead")));

        // MANAGEMENT + X combinations
        identityCombinations.put("MANAGEMENT+SALES", createIdentity("Sales Operations Director",
            "Kamu adalah arsitek mesin penjualan. Sistem dan proses yang kamu bangun memungkinkan tim untuk fokus pada relasi, bukan administrasi.",
            Arrays.asList("Sales Ops Director", "Revenue Operations Lead", "Commercial Excellence Manager")));

        identityCombinations.put("MANAGEMENT+TEACHING", createIdentity("Learning & Development Director",
            "Kamu membangun kapabilitas organisasi. Setiap program yang kamu rancang mengubah potensi menjadi performa.",
            Arrays.asList("L&D Director", "Corporate Academy Lead", "Capability Building Manager")));

        identityCombinations.put("MANAGEMENT+COOKING", createIdentity("Culinary Operations Director",
            "Kamu mengelola bisnis dapur skala besar. Dari supply chain hingga service delivery, kamu memastikan konsistensi kualitas.",
            Arrays.asList("Restaurant Group Operations Director", "Catering Operations Manager", "Food Service Director")));

        identityCombinations.put("MANAGEMENT+MUSIC", createIdentity("Studio Operations Engineer",
            "Kamu memastikan kreativitas mengalir tanpa hambatan. Infrastruktur dan proses yang kamu kelola memungkinkan artis untuk fokus pada karya.",
            Arrays.asList("Recording Studio Manager", "Live Event Operations Director", "Music Production Manager")));

        identityCombinations.put("MANAGEMENT+FINANCE", createIdentity("Finance Operations Manager",
            "Kamu adalah penjaga kesehatan finansial organisasi. Proses dan kontrol yang kamu bangun melindungi dari risiko dan memastikan compliance.",
            Arrays.asList("Finance Operations Lead", "Financial Controller", "Treasury Operations Manager")));

        identityCombinations.put("MANAGEMENT+MARKETING", createIdentity("Marketing Operations Director",
            "Kamu memastikan kreativitas dijalankan dengan presisi. Teknologi dan proses yang kamu kelola mengukur dan mempercepat marketing ROI.",
            Arrays.asList("Marketing Ops Director", "Campaign Operations Manager", "Marketing Technologist")));

        identityCombinations.put("MANAGEMENT+DESIGN", createIdentity("Design Operations Lead",
            "Kamu menskalakan kreativitas tanpa mengorbankan kualitas. Sistem dan tooling yang kamu bangun memungkinkan tim untuk deliver lebih banyak, lebih baik.",
            Arrays.asList("DesignOps Lead", "Creative Resource Manager", "Studio Operations Director")));

        identityCombinations.put("MANAGEMENT+OPERATIONS", createIdentity("Chief Operating Officer",
            "Kamu adalah eksekutor visi. Transformasi strategis menjadi operasional yang efisien adalah keahlianmu yang membedakan bisnis sukses dari yang stagnan.",
            Arrays.asList("VP Operations", "COO", "Business Operations Director")));

        // 3-Category Combinations (40 combinations)
        identityCombinations.put("WRITING+TECHNICAL+ANALYTICAL", createIdentity("Algorithm Auditor",
            "Kamu menganalisa dan menjelaskan cara kerja sistem secara tertulis. Di era AI, kemampuanmu membedah algoritma dan mengkomunikasikan temuan adalah kompas moral teknologi.",
            Arrays.asList("AI Ethics Documentation Lead", "Technical Research Writer", "Explainable AI Specialist")));

        identityCombinations.put("VISUAL+INTERPERSONAL+MANAGEMENT", createIdentity("Experiential Brand Director",
            "Kamu membangun pengalaman fisik dan visual untuk brand. Setiap touchpoint yang kamu rancang memperkuat emotional connection antara brand dan customer.",
            Arrays.asList("Brand Experience Director", "Retail Experience Designer", "Pop-up Event Director")));

        identityCombinations.put("WRITING+INTERPERSONAL+SALES", createIdentity("Conversion Copywriter Expert",
            "Kamu adalah penulis yang jago jualan lewat kata-kata. Kombinasi pemahaman psikologi, kemampuan menulis, dan teknik penjualan membuatmu arsitek revenue.",
            Arrays.asList("Direct Response Expert", "Launch Copy Strategist", "High-Conversion Writer")));

        identityCombinations.put("TECHNICAL+VISUAL+TEACHING", createIdentity("Creative Technologist",
            "Kamu mengajar cara pakai tool AI/Tech untuk desainer. Di persimpatan kreativitas dan teknologi, kamu membuka jalan bagi desainer untuk memanfaatkan kekuatan coding.",
            Arrays.asList("Creative Coding Instructor", "Design Tool Educator", "No-Code/Low-Code Trainer")));

        identityCombinations.put("ANALYTICAL+MANAGEMENT+COOKING", createIdentity("Cloud Kitchen Systems Designer",
            "Kamu membangun sistem efisiensi dapur digital. Dari kitchen display systems hingga delivery optimization, kamu arsitek revolusi kuliner.",
            Arrays.asList("Ghost Kitchen Consultant", "Virtual Restaurant Systems Architect", "Food Tech Operations Director")));

        identityCombinations.put("INTERPERSONAL+RESEARCH+WRITING", createIdentity("UX Researcher & Strategist",
            "Kamu adalah detektif kebutuhan pengguna. Research yang kamu lakukan dan strategi yang kamu tulis membentuk produk yang benar-benar solve problem.",
            Arrays.asList("User Research Lead", "Product Strategy Consultant", "Customer Insight Director")));

        identityCombinations.put("MANAGEMENT+TECHNICAL+MUSIC", createIdentity("Studio Operations Engineer",
            "Kamu mengelola teknologi dan proses di studio rekaman. Infrastruktur yang kamu bangun memungkinkan artist untuk menciptakan tanpa teknis barrier.",
            Arrays.asList("Studio Technical Director", "Audio Production Manager", "Live Sound Operations Lead")));

        identityCombinations.put("WRITING+VISUAL+MARKETING", createIdentity("Brand Content Director",
            "Kamu adalah arsitek narasi visual brand. Setiap konten yang kamu ciptakan memperkuat positioning dan mempercepat customer journey.",
            Arrays.asList("Content Strategy Director", "Brand Storytelling Lead", "Visual Marketing Head")));

        identityCombinations.put("TECHNICAL+ANALYTICAL+FINANCE", createIdentity("Quantitative Researcher",
            "Kamu membangun model prediktif untuk pasar finansial. Kombinasi coding, statistik, dan pemahaman pasar membuatmu pemain kunci di trading desk.",
            Arrays.asList("Quant Developer", "Risk Modeler", "Algorithmic Trader")));

        identityCombinations.put("VISUAL+ANALYTICAL+MARKETING", createIdentity("Creative Performance Analyst",
            "Kamu mengoptimalkan kreativitas berdasarkan data. Setiap visual yang kamu buat tidak hanya cantik, tetapi juga terbukti mengkonversi.",
            Arrays.asList("Creative Analyst", "Visual Optimization Lead", "Ad Creative Strategist")));

        identityCombinations.put("INTERPERSONAL+TEACHING+MANAGEMENT", createIdentity("Learning Experience Director",
            "Kamu memimpin transformasi organisasi melalui pembelajaran. Program yang kamu rancang mengubah perilaku dan membangun kapabilitas skala besar.",
            Arrays.asList("L&D Director", "Organizational Development Lead", "Corporate Academy Head")));

        identityCombinations.put("WRITING+ANALYTICAL+MARKETING", createIdentity("Content Analytics Strategist",
            "Kamu menggunakan data untuk mengarahkan strategi konten. Insight yang kamu hasilkan memastikan setiap konten yang diproduksi memiliki ROI positif.",
            Arrays.asList("Content Performance Lead", "SEO Content Strategist", "Data-Driven Editor")));

        identityCombinations.put("TECHNICAL+INTERPERSONAL+MARKETING", createIdentity("Developer Marketing Lead",
            "Kamu memasarkan produk teknis ke audience teknis. Pemahamanmu terhadap developer memungkinkan pesan marketing yang autentik dan efektif.",
            Arrays.asList("Developer Marketing Manager", "Technical Evangelist", "Product Marketing (Dev Tools)")));

        identityCombinations.put("VISUAL+TECHNICAL+DESIGN", createIdentity("Product Design Engineer",
            "Kamu mendesain produk yang manufacturable dan delightful. Kombinasi estetika, teknis, dan desain thinking menjadikanmu arsitek produk unggulan.",
            Arrays.asList("Product Designer", "Design Engineer", "Prototyping Lead")));

        identityCombinations.put("ANALYTICAL+SALES+MANAGEMENT", createIdentity("Revenue Operations Director",
            "Kamu mengelola mesin revenue dengan presisi data. Proses dan insight yang kamu bangun mengoptimalkan setiap stage funnel.",
            Arrays.asList("RevOps Director", "Sales Analytics VP", "GTM Operations Lead")));

        identityCombinations.put("WRITING+TEACHING+TECHNICAL", createIdentity("Technical Documentation Lead",
            "Kamu membangun knowledge base yang mengedukasi developer. Setiap dokumen yang kamu tulis mengurangi support ticket dan meningkatkan adoption.",
            Arrays.asList("Docs Lead", "Developer Education Manager", "Technical Writer (Senior)")));

        identityCombinations.put("VISUAL+SALES+INTERPERSONAL", createIdentity("Visual Sales Consultant",
            "Kamu menggunakan visual untuk mempersuasif. Presentasi dan pitch deck yang kamu rancang memenangkan deal besar.",
            Arrays.asList("Pitch Deck Specialist", "Visual Sales Enablement", "Presentation Designer")));

        identityCombinations.put("MANAGEMENT+MARKETING+FINANCE", createIdentity("Growth Operations Director",
            "Kamu mengelola growth engine dengan disiplin finansial. Setiap campaign dioptimalkan untuk CAC efficiency dan LTV maximization.",
            Arrays.asList("Growth Ops Lead", "Marketing Finance Director", "Performance Marketing VP")));

        identityCombinations.put("TECHNICAL+OPERATIONS+ANALYTICAL", createIdentity("Operations Data Engineer",
            "Kamu membangun infrastruktur data untuk operasional excellence. Real-time dashboards dan automated reports yang kamu buat memberikan visibility penuh.",
            Arrays.asList("Operations Data Lead", "Supply Chain Data Engineer", "Manufacturing Analytics Manager")));

        identityCombinations.put("WRITING+FINANCE+SALES", createIdentity("Investment Writer",
            "Kamu menjual konsep investasi melalui tulisan yang meyakinkan. Report dan analysis yang kamu produksi membentuk keputusan besar.",
            Arrays.asList("Investment Content Strategist", "Financial Sales Writer", "Wealth Management Communicator")));

        identityCombinations.put("VISUAL+MUSIC+TECHNICAL", createIdentity("Audio-Visual Systems Designer",
            "Kamu mendesain sistem integrasi audio dan visual. Dari venue besar hingga immersive installation, kamu menciptakan sinergi sensasional.",
            Arrays.asList("AV Systems Architect", "Live Event Tech Director", "Immersive Media Engineer")));

        identityCombinations.put("INTERPERSONAL+ANALYTICAL+MARKETING", createIdentity("Customer Insight Lead",
            "Kamu menggali dan menganalisis voice of customer. Insight yang kamu hasilkan mengarahkan strategi marketing dan product development.",
            Arrays.asList("Customer Analytics Manager", "Voice of Customer Director", "Market Research Lead")));

        identityCombinations.put("TEACHING+TECHNICAL+ANALYTICAL", createIdentity("Data Literacy Educator",
            "Kamu mengajarkan data skills ke organisasi. Setiap session yang kamu facilite membuka mata peserta terhadap kekuatan data-driven decision making.",
            Arrays.asList("Data Training Lead", "Analytics Educator", "Business Intelligence Trainer")));

        identityCombinations.put("MANAGEMENT+DESIGN+STRATEGY", createIdentity("Design Strategy Director",
            "Kamu memimpin design thinking untuk business strategy. Workshop dan framework yang kamu rancang membantu organisasi solve complex problem.",
            Arrays.asList("Design Strategy Lead", "Service Design Director", "Innovation Consultant")));

        identityCombinations.put("WRITING+MUSIC+MARKETING", createIdentity("Music Content Strategist",
            "Kamu menciptakan narasi yang mempromosikan musik. Dari press release hingga social media, kamu membangun story yang resonate.",
            Arrays.asList("Music Marketing Writer", "Artist Content Strategist", "Label Communications Lead")));

        identityCombinations.put("TECHNICAL+DESIGN+TEACHING", createIdentity("Design Tool Educator",
            "Kamu mengajar profesional untuk menguasai tools desain modern. Tutorial dan course yang kamu buat mengubah beginner menjadi expert.",
            Arrays.asList("Design Software Trainer", "Tooling Education Lead", "Creative Tech Instructor")));

        identityCombinations.put("VISUAL+COOKING+MARKETING", createIdentity("Food Content Creator",
            "Kamu menciptakan konten visual yang membuat orang lapar. Food photography dan stylingmu menggerakkan engagement dan sales.",
            Arrays.asList("Food Photographer", "Culinary Content Producer", "Recipe Developer (Visual)")));

        identityCombinations.put("ANALYTICAL+FINANCE+MANAGEMENT", createIdentity("FP&A Manager",
            "Kamu memimpin financial planning dengan presisi analitis. Forecast dan budget yang kamu bangun mengarahkan arah strategis organisasi.",
            Arrays.asList("Financial Planning Director", "Budget Analytics Lead", "Strategic Finance Manager")));

        identityCombinations.put("INTERPERSONAL+OPERATIONS+TECHNICAL", createIdentity("Technical Support Manager",
            "Kamu memimpin tim support yang memecahkan masalah teknis dengan human touch. Customer satisfaction dan resolution rate adalah metrik kebanggaanmu.",
            Arrays.asList("Support Operations Lead", "Customer Success Engineer", "Technical Account Lead")));

        identityCombinations.put("WRITING+RESEARCH+TEACHING", createIdentity("Research Educator",
            "Kamu mengajarkan metodologi riset dan menulis temuan. Setiap paper dan course yang kamu produksi meningkatkan literacy akademik.",
            Arrays.asList("Research Methods Instructor", "Academic Writing Coach", "Scholarly Communication Lead")));

        identityCombinations.put("VISUAL+MANAGEMENT+FINANCE", createIdentity("Visual Finance Director",
            "Kamu memimpin reporting dan komunikasi finansial visual. Dashboard dan presentation yang kamu rancang membuat stakeholder memahami performa dengan sekilas.",
            Arrays.asList("Financial Communication Director", "Investor Relations Design Lead", "Visual Reporting Manager")));

        identityCombinations.put("TECHNICAL+SALES+MANAGEMENT", createIdentity("Technical Sales Director",
            "Kamu memimpin tim sales yang menjual produk kompleks. Kombinasi pemahaman teknis dan leadership membuatmu pemimpin yang menghasilkan revenue besar.",
            Arrays.asList("Solutions Sales VP", "Enterprise Sales Director", "Technical Revenue Lead")));

        identityCombinations.put("ANALYTICAL+RESEARCH+WRITING", createIdentity("Research Writer",
            "Kamu mengubah temuan riset kompleks menjadi tulisan yang accessible. Buku, article, dan report yang kamu produksi mengedukasi dan menginspirasi.",
            Arrays.asList("Science Writer", "Research Journalist", "Academic Communicator")));

        identityCombinations.put("INTERPERSONAL+TEACHING+COOKING", createIdentity("Culinary Educator & Host",
            "Kamu mengajar memasak sambil menciptakan pengalaman sosial. Cooking class dan dining event yang kamu rancang menggabungkan edukasi dengan entertainment.",
            Arrays.asList("Cooking Instructor", "Culinary Event Host", "Food Workshop Facilitator")));

        identityCombinations.put("MANAGEMENT+MUSIC+MARKETING", createIdentity("Music Operations & Marketing Director",
            "Kamu mengelola rilis musik dari produksi hingga promosi. Strategy dan execution yang kamu orchestrate memaksimalkan reach dan revenue artist.",
            Arrays.asList("Label Operations Director", "Artist Marketing Manager", "Music Release Lead")));

        identityCombinations.put("WRITING+DESIGN+TECHNICAL", createIdentity("Design Systems Writer",
            "Kamu mendokumentasikan dan mengkomunikasikan sistem desain. Documentation yang kamu tulis memungkinkan konsistensi desain di scale.",
            Arrays.asList("Design Systems Documentarian", "Component Library Writer", "UX Writer")));

        identityCombinations.put("VISUAL+ANALYTICAL+RESEARCH", createIdentity("Visual Researcher",
            "Kamu meneliti dan memvisualisasikan kompleksitas. Infografis dan data visual yang kamu buat mengubah research menjadi insight yang actionable.",
            Arrays.asList("Research Visualization Lead", "Scientific Illustrator", "Data Journalist")));

        identityCombinations.put("TECHNICAL+FINANCE+OPERATIONS", createIdentity("Fintech Operations Engineer",
            "Kamu membangun dan mengoperasikan sistem finansial. Infrastructure yang kamu kelola memproses transaksi aman dan efisien skala besar.",
            Arrays.asList("Payment Systems Engineer", "Banking Operations Tech Lead", "Fintech Infrastructure Manager")));

        identityCombinations.put("INTERPERSONAL+SALES+MARKETING", createIdentity("Go-to-Market Lead",
            "Kamu mengorkestrasi peluncuran produk ke pasar. Kombinasi pemahaman customer, sales, dan marketing membuatmu peluncur sukses.",
            Arrays.asList("GTM Manager", "Product Launch Director", "Commercial Lead")));

        identityCombinations.put("ANALYTICAL+TEACHING+MANAGEMENT", createIdentity("Analytics Enablement Director",
            "Kamu membangun kapabilitas data-driven di seluruh organisasi. Program training dan sistem yang kamu rancang mengubah culture menjadi evidence-based.",
            Arrays.asList("Data Enablement Lead", "Analytics Academy Director", "BI Adoption Manager")));

        identityCombinations.put("WRITING+MARKETING+SALES", createIdentity("Revenue Content Strategist",
            "Kamu menciptakan content engine yang menghasilkan lead dan sales. Setiap piece of content yang kamu rancang memiliki clear path to revenue.",
            Arrays.asList("Content Marketing Manager", "Growth Content Lead", "Sales Content Strategist")));

        identityCombinations.put("VISUAL+TEACHING+TECHNICAL", createIdentity("Visual Tech Educator",
            "Kamu mengajar software visual dan teknis. Tutorial dan course yang kamu buat membuka akses bagi banyak orang ke dunia desain profesional.",
            Arrays.asList("Creative Software Instructor", "Visual Tools Trainer", "Design Platform Educator")));

        identityCombinations.put("MANAGEMENT+INTERPERSONAL+FINANCE", createIdentity("Client Relations Director",
            "Kamu memimpin hubungan dengan klien high-value. Kombinasi leadership, interpersonal skills, dan pemahaman finansial membuatmu trusted advisor.",
            Arrays.asList("Client Success Director", "Account Management VP", "Wealth Relationship Lead")));

        // Default for unmatched combinations
        identityCombinations.put("DEFAULT", createIdentity("Multi-Skilled Professional",
            "Kamu adalah profesional dengan kombinasi skill unik. Keberagaman kemampuanmu adalah aset berharga di dunia yang semakin membutuhkan adaptabilitas. Terus kembangkan keunikanmu.",
            Arrays.asList("Freelance Consultant", "Portfolio Career Builder", "Solopreneur")));
    }

    private Identity createIdentity(String title, String description, List<String> monetizationPaths) {
        Identity identity = new Identity(title, description, monetizationPaths);
        return identity;
    }

    public Identity synthesizeIdentity(List<String> skills) {
        // Map skills to categories
        Map<SkillCategory, List<String>> categorySkills = new HashMap<>();
        List<String> matchedSkills = new ArrayList<>();

        for (String skill : skills) {
            String normalizedSkill = skill.trim();
            SkillCategory category = skillDatabase.get(normalizedSkill);
            if (category != null) {
                categorySkills.computeIfAbsent(category, k -> new ArrayList<>()).add(normalizedSkill);
                matchedSkills.add(normalizedSkill);
            }
        }

        if (categorySkills.isEmpty()) {
            return generateDynamicIdentity(skills, new ArrayList<>(), new HashMap<>());
        }

        // Sort categories by count (descending)
        List<Map.Entry<SkillCategory, List<String>>> sortedCategories = categorySkills.entrySet()
            .stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
            .collect(Collectors.toList());

        // Get top 2 or 3 categories
        int topCount = Math.min(sortedCategories.size(), sortedCategories.size() >= 3 ? 3 : 2);
        List<SkillCategory> topCategories = sortedCategories.subList(0, topCount)
            .stream()
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        List<String> matchedCategories = topCategories.stream()
            .map(Enum::name)
            .collect(Collectors.toList());

        // Generate dynamic identity based on actual skills
        return generateDynamicIdentity(matchedSkills, matchedCategories, categorySkills);
    }

    private Identity generateDynamicIdentity(List<String> skills, List<String> categories, Map<SkillCategory, List<String>> categorySkills) {
        // Analyze dominant categories
        List<SkillCategory> topCategories = categorySkills.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
            .limit(3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        // Generate personalized title
        String title = generatePersonalizedTitle(topCategories, skills);

        // Generate personalized description
        String description = generatePersonalizedDescription(topCategories, skills, categorySkills);

        // Generate personalized monetization paths
        List<String> monetizationPaths = generatePersonalizedMonetization(topCategories, skills);

        Identity response = new Identity(title, description, monetizationPaths);
        response.setMatchedSkills(skills);
        response.setMatchedCategories(categories);
        
        return response;
    }

    private String generatePersonalizedTitle(List<SkillCategory> categories, List<String> skills) {
        if (categories.isEmpty()) {
            return "Multi-Skilled Professional";
        }

        // Get primary skill names for title generation
        String primarySkill = skills.get(0);
        String secondarySkill = skills.size() > 1 ? skills.get(1) : "";
        
        StringBuilder title = new StringBuilder();
        
        // Title patterns based on category combinations
        switch (categories.get(0)) {
            case WRITING:
                if (categories.size() > 1) {
                    switch (categories.get(1)) {
                        case TECHNICAL:
                            title.append("Technical Content Strategist");
                            break;
                        case ANALYTICAL:
                            title.append("Data Storyteller");
                            break;
                        case MARKETING:
                            title.append("Conversion Copy Architect");
                            break;
                        case VISUAL:
                            title.append("Visual Narrative Designer");
                            break;
                        default:
                            title.append("Strategic Content Creator");
                    }
                } else {
                    title.append("Expert Content Specialist");
                }
                break;
            case TECHNICAL:
                if (categories.size() > 1) {
                    switch (categories.get(1)) {
                        case WRITING:
                            title.append("Developer Advocate & Educator");
                            break;
                        case ANALYTICAL:
                            title.append("Data Infrastructure Engineer");
                            break;
                        case VISUAL:
                            title.append("Creative Technologist");
                            break;
                        case MANAGEMENT:
                            title.append("Technical Product Leader");
                            break;
                        default:
                            title.append("Full-Stack Solutions Architect");
                    }
                } else {
                    title.append("Technical Systems Expert");
                }
                break;
            case VISUAL:
                if (categories.size() > 1) {
                    switch (categories.get(1)) {
                        case TECHNICAL:
                            title.append("Interactive Experience Developer");
                            break;
                        case MARKETING:
                            title.append("Brand Visual Strategist");
                            break;
                        case MANAGEMENT:
                            title.append("Creative Operations Director");
                            break;
                        default:
                            title.append("Visual Design Expert");
                    }
                } else {
                    title.append("Visual Communications Specialist");
                }
                break;
            case ANALYTICAL:
                if (categories.size() > 1) {
                    switch (categories.get(1)) {
                        case TECHNICAL:
                            title.append("Analytics Engineer");
                            break;
                        case MANAGEMENT:
                            title.append("Data-Driven Operations Leader");
                            break;
                        case MARKETING:
                            title.append("Growth Analytics Strategist");
                            break;
                        default:
                            title.append("Business Intelligence Expert");
                    }
                } else {
                    title.append("Data Analysis Specialist");
                }
                break;
            case INTERPERSONAL:
                if (categories.size() > 1) {
                    switch (categories.get(1)) {
                        case SALES:
                            title.append("Relationship Sales Expert");
                            break;
                        case MANAGEMENT:
                            title.append("People & Culture Leader");
                            break;
                        case TECHNICAL:
                            title.append("Developer Relations Specialist");
                            break;
                        default:
                            title.append("Stakeholder Engagement Expert");
                    }
                } else {
                    title.append("Human-Centered Professional");
                }
                break;
            case MANAGEMENT:
                title.append("Strategic Operations Leader");
                break;
            default:
                title.append("Versatile Professional");
        }

        return title.toString();
    }

    /**
     * WAHYU TAHIR - Mentor Karir Praktis
     * 
     * Persona: Wahyu Tahir - praktis, realistis, anti-basa-basi
     * Language: 100% Bahasa Indonesia Lo/Gue (NO English mixing)
     * Format: HTML ONLY (<p>, <b>, <ul><li>), NO MARKDOWN (**)
     * Focus: Solusi nyata, bukan teori
     */
    private String generatePersonalizedDescription(List<SkillCategory> categories, List<String> skills, Map<SkillCategory, List<String>> categorySkills) {
        StringBuilder desc = new StringBuilder();
        
        // Analisis: Skill Utama vs Asset
        SkillAnalysis analysis = analyzeSkills(skills, categories);
        String primarySkill = analysis.primaryService;
        List<String> assets = analysis.supportingAssets;
        
        // Generate nama profesi unik
        String uniqueProfession = generateUniqueProfession(primarySkill, assets, skills, categories);
        
        // IDENTITAS: Kenapa irisan skill ini mahal
        desc.append(generateIdentity(uniqueProfession, primarySkill, assets, skills, categories));
        
        // ROADMAP 90 HARI: Langkah nyata bukan teori
        desc.append(generatePracticalRoadmap(primarySkill, assets, skills, categories));
        
        // MONETISASI: 3 tahap realistis
        desc.append(generateMonetizationHTML(primarySkill, assets, skills, categories));
        
        // CLOSING: Tamparan keras
        desc.append("<br><br><p><b>⚡ ");
        desc.append(generateHardSlap());
        desc.append("</b></p>");
        
        return desc.toString();
    }
    
    /**
     * Bedakan Skill Utama vs Asset
     * Asset: motor, mobil, laptop, kamera, alat-alat fisik
     * Skill Utama: kemampuan yang bisa dijual
     */
    private SkillAnalysis analyzeSkills(List<String> skills, List<SkillCategory> categories) {
        String primarySkill = skills.get(0);
        List<String> assets = new ArrayList<>();
        
        // Kata kunci asset (bukan skill utama)
        Set<String> assetKeywords = new HashSet<>(Arrays.asList(
            "motor", "mobil", "sepeda motor", "kendaraan", "rumah", "gedung", "laptop", "komputer", 
            "hp", "smartphone", "kamera", "alat", "peralatan", "mesin", "perabotan"
        ));
        
        for (String skill : skills) {
            String skillLower = skill.toLowerCase();
            boolean isAsset = assetKeywords.stream().anyMatch(keyword -> skillLower.contains(keyword));
            
            if (isAsset) {
                assets.add(skill);
            }
        }
        
        // Kalau skill pertama adalah asset, cari skill non-asset sebagai primary
        if (assets.contains(skills.get(0)) && skills.size() > 1) {
            for (String s : skills) {
                String sLower = s.toLowerCase();
                if (!assetKeywords.stream().anyMatch(keyword -> sLower.contains(keyword))) {
                    primarySkill = s;
                    break;
                }
            }
        }
        
        return new SkillAnalysis(primarySkill, assets);
    }
    
    private class SkillAnalysis {
        final String primaryService;
        final List<String> supportingAssets;
        
        SkillAnalysis(String primaryService, List<String> supportingAssets) {
            this.primaryService = primaryService;
            this.supportingAssets = supportingAssets;
        }
    }
    
    /**
     * Generate nama profesi unik - jangan gabungan absurd
     */
    private String generateUniqueProfession(String primarySkill, List<String> assets, 
                                            List<String> skills, List<SkillCategory> categories) {
        String primaryLower = primarySkill.toLowerCase();
        
        // Menulis + Motor = Reporter Lapangan
        if ((primaryLower.contains("tulis") || primaryLower.contains("writing") || categories.contains(SkillCategory.WRITING))
            && !assets.isEmpty() && assets.stream().anyMatch(a -> a.toLowerCase().contains("motor") || a.toLowerCase().contains("mobil"))) {
            return "Reporter Lapangan";
        }
        
        // Masak + Akuntansi = Consultant Bisnis F&B
        if ((primaryLower.contains("masak") || primaryLower.contains("cooking") || categories.contains(SkillCategory.COOKING))
            && categories.contains(SkillCategory.ANALYTICAL)) {
            return "Consultant Bisnis F&B";
        }
        
        // Masak + Motor = Katering Mobile
        if ((primaryLower.contains("masak") || primaryLower.contains("cooking"))
            && !assets.isEmpty() && assets.stream().anyMatch(a -> a.toLowerCase().contains("motor"))) {
            return "Katering Mobile";
        }
        
        // Mengajar + Motor = Guru Privat Home-to-Home
        if ((primaryLower.contains("mengajar") || primaryLower.contains("ngaji") || primaryLower.contains("tutor") || categories.contains(SkillCategory.TEACHING))
            && !assets.isEmpty() && assets.stream().anyMatch(a -> a.toLowerCase().contains("motor"))) {
            return "Guru Privat Home-to-Home";
        }
        
        // Sales + Masak = Consultant Bisnis Kuliner
        if (categories.contains(SkillCategory.SALES) && categories.contains(SkillCategory.COOKING)) {
            return "Consultant Bisnis Kuliner";
        }
        
        // Sales + Teknis = Teknical Sales Specialist
        if (categories.contains(SkillCategory.SALES) && categories.contains(SkillCategory.TECHNICAL)) {
            return "Teknical Sales Specialist";
        }
        
        // Writing + Marketing = Copywriter Strategis
        if (categories.contains(SkillCategory.WRITING) && categories.contains(SkillCategory.MARKETING)) {
            return "Copywriter Strategis";
        }
        
        // Visual + Marketing = Brand Visual Strategist
        if (categories.contains(SkillCategory.VISUAL) && categories.contains(SkillCategory.MARKETING)) {
            return "Brand Visual Strategist";
        }
        
        // Analytical + Management = Business Analyst
        if (categories.contains(SkillCategory.ANALYTICAL) && categories.contains(SkillCategory.MANAGEMENT)) {
            return "Business Analyst";
        }
        
        // Default: nama profesi berdasarkan skill utama
        if (categories.contains(SkillCategory.TEACHING)) {
            return "Fasilitator Profesional";
        } else if (categories.contains(SkillCategory.TECHNICAL)) {
            return "Spesialis Solusi Teknis";
        } else if (categories.contains(SkillCategory.VISUAL)) {
            return "Desainer Visual";
        } else if (categories.contains(SkillCategory.WRITING)) {
            return "Penulis Profesional";
        } else if (categories.contains(SkillCategory.SALES)) {
            return "Sales Professional";
        } else {
            return "Spesialis " + primarySkill;
        }
    }
    
    /**
     * Generate identitas - kenapa irisan skill ini mahal
     */
    private String generateIdentity(String profession, String primarySkill, List<String> assets, 
                                     List<String> skills, List<SkillCategory> categories) {
        StringBuilder identity = new StringBuilder();
        
        identity.append("<p><b>").append(profession).append("</b></p>");
        identity.append("<br><p>Gini, lo punya ");
        
        // Sebutkan skill yang ada
        for (int i = 0; i < skills.size(); i++) {
            if (i > 0) identity.append(" + ");
            identity.append("<b>").append(skills.get(i)).append("</b>");
        }
        identity.append(". </p>");
        
        // Jelaskan kenapa mahal
        identity.append("<p>Kebanyakan orang cuma jago ").append(primarySkill).append(" doang. ");
        
        if (!assets.isEmpty()) {
            identity.append("Tapi lo beda. Lo punya ").append(String.join(", ", assets)).append(". ");
            identity.append("Ini bikin lo bisa deliver jasa yang orang lain gak bisa. ");
            identity.append("Lo gak cuma bisa kerja, tapi lo bisa kerja lebih cepat dan lebih luas.</p>");
        } else if (skills.size() > 1) {
            identity.append("Tapi lo beda. Lo bisa kombinasiin skill-skill ini jadi satu paket yang lengkap. ");
            identity.append("Orang lain jago satu hal, lo jago beberapa hal sekaligus. ");
            identity.append("Ini bikin lo bisa charge harga lebih tinggi karena lo bisa kasih solusi end-to-end.</p>");
        } else {
            identity.append("Tapi kalau lo fokus dan serius, lo bisa jadi yang terbaik di niche ini. ");
            identity.append("Yang penting lo punya cara buat monetize skill ini dengan benar.</p>");
        }
        
        return identity.toString();
    }
    
    /**
     * Generate roadmap praktis - langkah nyata bukan teori
     */
    private String generatePracticalRoadmap(String primarySkill, List<String> assets, 
                                             List<String> skills, List<SkillCategory> categories) {
        StringBuilder roadmap = new StringBuilder();
        
        roadmap.append("<br><br><p><b>📋 ROADMAP 90 HARI - LANGKAH NYATA</b></p>");
        
        // BULAN 1: Skill - kasih 1 teknik spesifik
        roadmap.append("<br><p><b>BULAN 1: SKILL - KASIH 1 TEKNIK SPESIFIK</b></p>");
        roadmap.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        
        String specificTechnique = generateSpecificTechnique(primarySkill, assets, skills, categories);
        roadmap.append("<li style='margin-bottom: 6px;'>").append(specificTechnique).append("</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>Praktikin tiap hari minimal 1 jam</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>Catat progress lo di buku catatan</li>");
        roadmap.append("</ul>");
        
        // BULAN 2: Karya - bikin 1 produk/jasa nyata
        roadmap.append("<br><p><b>BULAN 2: KARYA - BIKIN 1 PRODUK/JASA NYATA</b></p>");
        roadmap.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        
        String specificProject = generateSpecificProject(primarySkill, assets, skills, categories);
        roadmap.append("<li style='margin-bottom: 6px;'>").append(specificProject).append("</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>Dokumentasiin proses dan hasilnya</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>Tawarin gratis ke 3 orang pertama buat dapet testimoni</li>");
        roadmap.append("</ul>");
        
        // BULAN 3: Duit - target siapa yang harus di-DM/ditemui
        roadmap.append("<br><p><b>BULAN 3: DUIT - TARGET SIAPA YANG HARUS DI-DM/DITEMUI</b></p>");
        roadmap.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        
        String specificTarget = generateSpecificTarget(primarySkill, assets, skills, categories);
        roadmap.append("<li style='margin-bottom: 6px;'>").append(specificTarget).append("</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>DM/kontak minimal 15 orang dalam 2 minggu</li>");
        roadmap.append("<li style='margin-bottom: 6px;'>Close 1-2 deal pertama, fokus ke testimoni</li>");
        roadmap.append("</ul>");
        
        return roadmap.toString();
    }
    
    /**
     * Generate 1 teknik spesifik yang harus dipelajari
     */
    private String generateSpecificTechnique(String primarySkill, List<String> assets, 
                                            List<String> skills, List<SkillCategory> categories) {
        String primaryLower = primarySkill.toLowerCase();
        
        // Masak + Akuntansi = Hitung Food Cost
        if ((primaryLower.contains("masak") || primaryLower.contains("cooking"))
            && categories.contains(SkillCategory.ANALYTICAL)) {
            return "Hitung Food Cost 5 menu andalan lo dengan spreadsheet";
        }
        
        // Masak = Pelajari teknik 1 masakan yang paling laku
        if (primaryLower.contains("masak") || primaryLower.contains("cooking")) {
            return "Pelajari teknik 1 masakan yang paling laku di area lo";
        }
        
        // Writing = Pelajari teknik copywriting AIDA
        if (primaryLower.contains("tulis") || primaryLower.contains("writing")) {
            return "Pelajari teknik copywriting AIDA (Attention, Interest, Desire, Action)";
        }
        
        // Coding = Pelajari 1 framework yang lagi hot
        if (primaryLower.contains("coding") || primaryLower.contains("program") || categories.contains(SkillCategory.TECHNICAL)) {
            return "Pelajari 1 framework yang lagi hot di industri";
        }
        
        // Design = Pelajari prinsip desain dasar
        if (primaryLower.contains("design") || primaryLower.contains("desain") || categories.contains(SkillCategory.VISUAL)) {
            return "Pelajari prinsip desain dasar: balance, contrast, hierarchy";
        }
        
        // Sales = Pelajari teknik closing
        if (categories.contains(SkillCategory.SALES)) {
            return "Pelajari teknik closing: assumptive close dan urgency close";
        }
        
        // Teaching = Pelajari metode pembelajaran
        if (primaryLower.contains("mengajar") || primaryLower.contains("ngaji") || categories.contains(SkillCategory.TEACHING)) {
            return "Pelajari metode pembelajaran yang interaktif";
        }
        
        // Default
        return "Pelajari 1 teknik spesifik di bidang ".concat(primarySkill).concat(" yang paling dibutuhin market");
    }
    
    /**
     * Generate 1 project/karya nyata yang harus dibuat
     */
    private String generateSpecificProject(String primarySkill, List<String> assets, 
                                          List<String> skills, List<SkillCategory> categories) {
        String primaryLower = primarySkill.toLowerCase();
        
        // Masak + Akuntansi = Bikin spreadsheet HPP otomatis
        if ((primaryLower.contains("masak") || primaryLower.contains("cooking"))
            && categories.contains(SkillCategory.ANALYTICAL)) {
            return "Bikin spreadsheet HPP otomatis untuk 10 menu andalan lo";
        }
        
        // Masak = Bikin 5 menu andalan yang bisa dijual
        if (primaryLower.contains("masak") || primaryLower.contains("cooking")) {
            return "Bikin 5 menu andalan yang bisa lo jual dengan margin minimal 50%";
        }
        
        // Writing = Bikin 5 artikel lengkap
        if (primaryLower.contains("tulis") || primaryLower.contains("writing")) {
            return "Bikin 5 artikel lengkap dengan headline yang kuat untuk 1 niche";
        }
        
        // Coding = Bikin 1 aplikasi simple
        if (primaryLower.contains("coding") || primaryLower.contains("program") || categories.contains(SkillCategory.TECHNICAL)) {
            return "Bikin 1 aplikasi simple yang solve 1 masalah nyata";
        }
        
        // Design = Bikin brand kit untuk 1 UMKM
        if (primaryLower.contains("design") || primaryLower.contains("desain") || categories.contains(SkillCategory.VISUAL)) {
            return "Bikin brand kit lengkap (logo, kartu nama, feed Instagram) untuk 1 UMKM";
        }
        
        // Sales = Bikin proposal penjualan
        if (categories.contains(SkillCategory.SALES)) {
            return "Bikin proposal penjualan yang meyakinkan untuk 1 produk";
        }
        
        // Teaching = Bikin kurikulum 1 bulan
        if (primaryLower.contains("mengajar") || primaryLower.contains("ngaji") || categories.contains(SkillCategory.TEACHING)) {
            return "Bikin kurikulum lengkap untuk program 1 bulan";
        }
        
        // Default
        return "Bikin 1 karya yang nunjukkin skill ".concat(primarySkill).concat(" lo dengan jelas");
    }

    /**
     * Generate target spesifik - siapa yang harus di-DM/ditemui
     */
    private String generateSpecificTarget(String primarySkill, List<String> assets, 
                                         List<String> skills, List<SkillCategory> categories) {
        String primaryLower = primarySkill.toLowerCase();
        
        // Masak = DM pemilik warung kopi di dekat rumah
        if (primaryLower.contains("masak") || primaryLower.contains("cooking")) {
            return "DM pemilik 5 warung kopi di dekat rumah lo dengan script: \"Gue bisa bantu bikin menu baru buat warung lo\"";
        }
        
        // Writing = DM pemilik bisnis lokal
        if (primaryLower.contains("tulis") || primaryLower.contains("writing")) {
            return "DM pemilik 10 bisnis lokal di Instagram dengan script: \"Lo butuh konten buat bisnis lo? Gue bisa bantu\"";
        }
        
        // Design = DM pemilik UMKM baru
        if (primaryLower.contains("design") || primaryLower.contains("desain") || categories.contains(SkillCategory.VISUAL)) {
            return "DM pemilik 10 UMKM baru di area lo dengan script: \"Gue bisa bantu bikin logo buat bisnis lo\"";
        }
        
        // Coding = DM pemilik bisnis yang butuh website
        if (primaryLower.contains("coding") || primaryLower.contains("program") || categories.contains(SkillCategory.TECHNICAL)) {
            return "DM pemilik 10 bisnis yang gak punya website dengan script: \"Bisnis lo butuh website? Gue bisa bantu bikin\"";
        }
        
        // Sales = DM pemilik bisnis yang butuh sales
        if (categories.contains(SkillCategory.SALES)) {
            return "DM pemilik 10 bisnis yang produknya bagus tapi penjualan kurang dengan script: \"Gue bisa bantu naikin penjualan lo\"";
        }
        
        // Teaching = DM orang tua yang punya anak
        if (primaryLower.contains("mengajar") || primaryLower.contains("ngaji") || categories.contains(SkillCategory.TEACHING)) {
            return "DM 10 orang tua di komplek perumahan dengan script: \"Lo butuh privat ngaji buat anak lo? Gue bisa datang ke rumah\"";
        }
        
        // Default
        return "DM 15 orang yang lo rasa butuh jasa ".concat(primarySkill).concat(" dengan penawaran yang spesifik");
    }

    private String generateNicheDescription(List<SkillCategory> categories) {
        if (categories.isEmpty()) return "talent";
        
        StringBuilder niche = new StringBuilder();
        for (int i = 0; i < Math.min(categories.size(), 3); i++) {
            if (i > 0) niche.append("-");
            niche.append(categories.get(i).name().toLowerCase());
        }
        return niche.toString();
    }

    /**
     * Generate monetisasi - 3 tahap realistis
     */
    private String generateMonetizationHTML(String primarySkill, List<String> assets, 
                                            List<String> skills, List<SkillCategory> categories) {
        StringBuilder monetization = new StringBuilder();
        
        monetization.append("<br><br><p><b>💰 JALUR DUIT - 3 TAHAP REALISTIS</b></p>");
        
        String primaryLower = primarySkill.toLowerCase();
        
        // Tahap 1: Freelance/Jasa
        monetization.append("<br><p><b>Tahap 1: Freelance/Jasa (Bulan 1-3)</b></p>");
        monetization.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        
        if (primaryLower.contains("masak") || primaryLower.contains("cooking")) {
            monetization.append("<li style='margin-bottom: 6px;'>Jual 15-20 porsi per hari ke teman kantor/tetangga</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Harga 25-35rb/porsi, modal 50%</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 5-7jt omzet per bulan</li>");
        } else if (primaryLower.contains("tulis") || primaryLower.contains("writing")) {
            monetization.append("<li style='margin-bottom: 6px;'>Tulis artikel untuk blog atau jadi penulis lepas</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Bayaran 100-300rb per artikel</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 10-15 artikel per bulan = 2-4jt</li>");
        } else if (primaryLower.contains("design") || primaryLower.contains("desain") || categories.contains(SkillCategory.VISUAL)) {
            monetization.append("<li style='margin-bottom: 6px;'>Bikin logo/poster untuk UMKM lokal</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Charge 300-800rb per project</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 5-8 project per bulan = 2-5jt</li>");
        } else if (primaryLower.contains("coding") || primaryLower.contains("program") || categories.contains(SkillCategory.TECHNICAL)) {
            monetization.append("<li style='margin-bottom: 6px;'>Bikin website/aplikasi simple untuk bisnis lokal</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Charge 500rb-2jt per project</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 2-4 project per bulan = 2-5jt</li>");
        } else if (primaryLower.contains("mengajar") || primaryLower.contains("ngaji") || categories.contains(SkillCategory.TEACHING)) {
            monetization.append("<li style='margin-bottom: 6px;'>Tawarin les privat ke tetangga</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Tarif 50-100rb per jam</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 5-10 murid = 3-5jt per bulan</li>");
        } else {
            monetization.append("<li style='margin-bottom: 6px;'>Tawarin jasa ").append(primarySkill).append(" ke orang di sekitar lo</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Charge 100-500rb tergantung kerjaan</li>");
            monetization.append("<li style='margin-bottom: 6px;'>Target: 3-5 deal pertama = 1-3jt per bulan</li>");
        }
        monetization.append("</ul>");
        
        // Tahap 2: Scale up
        monetization.append("<br><p><b>Tahap 2: Scale Up (Bulan 4-12)</b></p>");
        monetization.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        monetization.append("<li style='margin-bottom: 6px;'>Bikin paket layanan yang lebih lengkap</li>");
        monetization.append("<li style='margin-bottom: 6px;'>Naikin harga 2-3x dari awal</li>");
        monetization.append("<li style='margin-bottom: 6px;'>Target: 5-10jt per bulan</li>");
        monetization.append("</ul>");
        
        // Tahap 3: Long term
        monetization.append("<br><p><b>Tahap 3: Long Term (Tahun 1-2)</b></p>");
        monetization.append("<ul style='margin-left: 20px; margin-top: 8px;'>");
        monetization.append("<li style='margin-bottom: 6px;'>Buka bisnis sendiri atau apply posisi senior</li>");
        monetization.append("<li style='margin-bottom: 6px;'>Gaji target: 8-20jt per bulan</li>");
        monetization.append("<li style='margin-bottom: 6px;'>Atau omzet 20-50jt per bulan kalau punya bisnis sendiri</li>");
        monetization.append("</ul>");
        
        return monetization.toString();
    }
    
    /**
     * Generate monetisasi untuk API response (legacy format - returns List<String>)
     */
    private List<String> generatePersonalizedMonetization(List<SkillCategory> categories, List<String> skills) {
        List<String> paths = new ArrayList<>();
        
        String primarySkill = skills.get(0);
        List<String> assets = new ArrayList<>();
        
        // Simple asset detection
        Set<String> assetKeywords = new HashSet<>(Arrays.asList(
            "motor", "mobil", "sepeda motor", "kendaraan", "rumah", "gedung", "laptop", "komputer", 
            "hp", "smartphone", "kamera", "alat", "peralatan", "mesin", "perabotan"
        ));
        
        for (String skill : skills) {
            String skillLower = skill.toLowerCase();
            if (assetKeywords.stream().anyMatch(keyword -> skillLower.contains(keyword))) {
                assets.add(skill);
            }
        }
        
        // Generate HTML monetization as single string
        String monetizationHTML = generateMonetizationHTML(primarySkill, assets, skills, categories);
        paths.add(monetizationHTML);
        
        return paths;
    }
    
    /**
     * Generate tamparan keras - 1 kalimat agar user tidak malas
     */
    private String generateHardSlap() {
        String[] slaps = {
            "Gak ada yang namanya \"gue belum siap\". Lo gak akan pernah siap. Sekarang atau gak sama sekali.",
            "90 hari dari sekarang, lo bakal tetap di tempat yang sama kalau lo gak mulai hari ini.",
            "Skill lo udah cukup. Yang kurang adalah nyali buat mulai.",
            "Gak ada yang peduli sama rencana lo. Mereka cuma peduli sama hasil lo.",
            "Mikirin aja gak bikin lo kaya. Action yang bikin lo kaya.",
            "Gue udah kasih roadmap. Tinggal lo jalanin atau gak. Pilihan lo.",
            "Alasan terbaik buat mulai adalah gak ada alasan sama sekali."
        };
        return slaps[(int)(Math.random() * slaps.length)];
    }
}
