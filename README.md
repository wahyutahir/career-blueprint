# Career Blueprint Skill Synthesizer

Aplikasi web yang membantu user menggabungkan 3-10 skill "nanggung" mereka menjadi satu identitas karir yang unik dan bernilai tinggi, sesuai filosofi buku "Career Blueprint" oleh Wahyu Tahir.

## 🎯 Tujuan Aplikasi

Membantu profesional menemukan identitas karir unik mereka dengan menggabungkan berbagai skill yang mereka miliki, daripada terjebak menjadi "figuran" di satu bidang saja.

## 🛠️ Teknologi

- **Backend**: Java 17 + Spring Boot 3.2
- **Frontend**: HTML5 + Tailwind CSS (via CDN)
- **Build Tool**: Maven

## 📁 Struktur Project

```
careerBlueprint/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
├── src/
│   └── main/
│       ├── java/
│       │   └── com/careerblueprint/
│       │       ├── SkillSynthesizerApplication.java    # Main Spring Boot app
│       │       ├── controller/
│       │       │   └── SynthesizerController.java      # REST API endpoints
│       │       ├── enums/
│       │       │   └── SkillCategory.java              # Skill category enum
│       │       ├── model/
│       │       │   └── Identity.java                   # Identity response model
│       │       └── service/
│       │           └── SkillSynthesizerService.java    # Core business logic
│       └── resources/
│           ├── application.properties                  # App configuration
│           └── static/
│               └── index.html                          # Frontend UI
```

## 🚀 Cara Menjalankan

### Prerequisites
- Java 17 atau lebih tinggi
- Maven 3.8+

### Langkah-langkah

1. **Build project**:
   ```bash
   mvn clean package
   ```

2. **Jalankan aplikasi**:
   ```bash
   mvn spring-boot:run
   ```
   
   Atau jalankan JAR:
   ```bash
   java -jar target/skill-synthesizer-1.0.0.jar
   ```

3. **Buka browser**:
   Akses aplikasi di http://localhost:8080

## 📡 API Endpoints

### POST `/api/synthesize`
Menerima list skill dan mengembalikan identitas unik.

**Request Body**:
```json
{
  "skills": ["Coding", "Menulis", "Excel"]
}
```

**Response**:
```json
{
  "title": "Algorithm Auditor",
  "description": "Kamu menganalisa dan menjelaskan...",
  "monetizationPaths": [
    "AI Ethics Documentation Lead",
    "Technical Research Writer",
    "Explainable AI Specialist"
  ],
  "matchedSkills": ["Coding", "Menulis", "Excel"],
  "matchedCategories": ["TECHNICAL", "WRITING", "ANALYTICAL"]
}
```

### GET `/api/skills`
Mengembalikan semua skill yang tersedia dalam database.

**Response**:
```json
{
  "Coding": "TECHNICAL",
  "Menulis": "WRITING",
  "Excel": "ANALYTICAL",
  ...
}
```

## 🎨 Fitur Frontend

- **Dark Theme** dengan palette Zinc/Slate yang elegan
- **Skill Input** dengan chips/tags yang dapat dihapus
- **Skill Suggestions** untuk input cepat
- **Loading Animation** dengan teks berubah:
  - "Membakar Mental Nyam-Nyam..."
  - "Meraut Bambu Karirmu..."
  - "Mencampur Kode dan Kreativitas..."
  - "Meramu Formula Keberhasilan..."
  - "Menyatukan Puzzle Skill-mu..."
- **Result Card** yang menampilkan:
  - Judul identitas unik
  - Deskripsi motivasional
  - Kategori yang terdeteksi
  - 3 jalur monetisasi
- **Share ke WhatsApp** untuk membagikan hasil

## 📊 Database Skill (50+ Skills)

Aplikasi memiliki 15 kategori dengan 50+ skill:

| Kategori | Contoh Skill |
|----------|--------------|
| WRITING | Menulis, Copywriting, SEO Writing, Technical Writing |
| TECHNICAL | Coding, Programming, Web Development, Cloud Computing |
| VISUAL | Graphic Design, Photography, Video Editing, UI Design |
| INTERPERSONAL | Public Speaking, Negotiation, Leadership |
| ANALYTICAL | Excel, Data Analysis, Statistics, SQL |
| MANAGEMENT | Project Management, Strategic Planning |
| SALES | Sales, Lead Generation, Account Management |
| TEACHING | Teaching, Training, Curriculum Design |
| COOKING | Cooking, Baking, Culinary Arts |
| MUSIC | Music Production, Audio Engineering |
| FINANCE | Accounting, Financial Analysis, Investment |
| MARKETING | Digital Marketing, Social Media, SEO |
| DESIGN | Interior Design, Product Design |
| OPERATIONS | Supply Chain, Logistics, Process Optimization |

## 🎭 Kombinasi Identitas (100+)

Aplikasi memiliki database 100+ kombinasi identitas unik, contoh:

- **WRITING + TECHNICAL** → Technical Documentalist
- **VISUAL + INTERPERSONAL + MANAGEMENT** → Experiential Brand Director
- **ANALYTICAL + MANAGEMENT + COOKING** → Cloud Kitchen Systems Designer
- **INTERPERSONAL + RESEARCH + WRITING** → UX Researcher & Strategist
- **MANAGEMENT + TECHNICAL + MUSIC** → Studio Operations Engineer

## 📝 Quote

> "Jangan mau jadi figuran. Ambil alih panggung utama hidupmu."
> — Wahyu Tahir

## 📄 Lisensi

MIT License - Free to use and modify.

---

Dibuat dengan ❤️ untuk para pemimpi yang ingin mengambil alih panggung utama hidup mereka.
