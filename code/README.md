# University course system

## TODO

- Own API for JQuery/JS: In progress
- JQuery dynamic updates
- Third party API integration: In progress
- Ingegrate adding teachers to Course in add/update: Add finished, update almost.
- My courses: Done.
- Student signup: make request via ajax instead and report back that status is pending

## Database

**users:**

-  first_name (string) 
-  last_name (string) 
-  type: student/teacher/admin (int)

user_courses (many to many between student users, courses)

**courses:**

-  name_da (string)
-  name_en (string)
-  semester (int)
-  class_code (string)
-  study_programme (string)
-  mandatory_or_elective (string) * 
-  ects (int)
-  course_language (string) * 
-  min_students (int)
-  expected_students (int)
-  max_students (int)
-  prerequisites (string)
-  learning_outcome (string)
-  content (string)
-  exam_form (string)

-  teachers (FK?)

* could be boolean but isn't in the report


### API (documented via Swagger)

API + documentation:  
http://35.159.46.191/swagger-ui.html

**councelor:**

- email	(string)
- firstname	(string)
- id (int32)
- lastname (string)

- students (FK)

**course:**

- description	(string)
- ects	(string)
- id	(int32)
- languange	(string)
- mandatory	(boolean)
- name	(string)
- namedanish	(string)
- numberOfTeachers	($int32)
- semester	integer(int32)
- studyprogramme	(string)

**student:**

- email	(string)
- enabled	(int32)
- id (int64)
- name (string)
- password (string)
- username (string)

- counselor	Counselor (FK)

**teachers:**

- email	(string)
- id (int32)
- name (string)
