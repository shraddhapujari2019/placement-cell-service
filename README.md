# placement-cell-service
Springboot backend service 

Requirements - 
--Placement Cell
--Project by Shraddha Anil Pujari

--There will be two types of accounts
1. Students  - User UI 
2. Admin (Training and Placement Officer) - Admin UI

--Students
1. Students will create their profile.
--Students will insert their data as per forms on the website.
--Students have to use their personal email address to create the profile.
--A verification code will be sent to the email address to verify the email address. // gmail
--Students have to insert below data while creating the profile.

	A. Personal Data
		--First Name
		--Middle Name
		--Last Name
		--Mobile Number
		--Personal Email Address
		--College Email Address
		--Permenent Address
		--Current Address
		--Date of Birth
		--Gender

	B. Educational Data
		--Course Name
		--Admission Year
		--Current Semester
		--Division
		--College Name (Should be populated Automatically)
		--SSC Passing Year
		--SSC Percentage Marks
		--HSC Passing Year
		--HSC Percentage Marks
		--Highest Qualification
		--Highest Qualification passing year
		--Highest Qualification marks
		--Sem 1 CGPA
		--Sem 2 CGPA
		--Sem 3 CGPA
		--Sem 4 CGPA
		--Active Backlogs
		--Total Backlogs

	C. Experience Data
		--Experience (Y/N)
		--Experience Start Date
		--Experience End Date
		--Company Name
		--Position
		--Role

	D. Others (if any)
		--Certifications
		--Cources
		
---------**********----------**********----------**********----------

--Admin (TPO)

1. Admins will also verify the student profile once they are created.
--Profiles will be in pending state unless approved by Admin.

2. Add the profiles of the company when they arrive for placement.
--Below are the details needs to be provided in the company profile.

	A. Company Data
		--Company Name
		--Offered CTC
		--Role
		--Location
		--Organization type (MNC/Non-MNC)
		--Sector
		--Company Info
		--Company official website

	B. Eligibility Criteria
		--SSC Marks
		--HSC Marks
		--Graduation
		--Active Backlog allowed (Y/N)
		--Number of active backlogs allowed (If above is Y)
		--Historical Backlog allowed (Y/N)
		--Number of historical backlogs allowed (If above is Y)
		--Drive location
		--Date of Drive

3. Create/Update the drive details

		--A Drive status page must be accessible for Admin.
		--Below data must be visible there.
		--Company ID
		--Date of Drive
		--List of eligible students
		--List of applied students

4. A placement status page needs to be created for Admin
		--This wil contain the data of students who has appeared for a drive along with the outcome of the drive.
		--This page will have a filter which will only show the data of students who are placed.
		--Below data must be visible there.
		--Student ID
		--Company ID
		--Placement status
		--Date of placement
		--Offered Salary
		--DOJ
		
---------**********----------**********----------**********----------

--When company drive is scheduled, all the eligible students should get email notification to apply for the drive.
--Notification should contain brief details of the company and drive.

--TPO should able to pull out the data of all the eligible students for a drive.

--If a student is eligible for a drive then a apply button should appear on his profile along with details of the drive.

--TPO should able to pull out the data of students who has applied/not applied for the drive.

--Student should able to see all the upcoming drives for which he has applied/which tpo updated.

---------**********----------**********----------**********----------
--Below is some standard data needs to be provided via dropdown menu.
1. Qualification List (Containing all the available graduation options)
2. College name (IIMS Pune)
3. Semester (I, II, III, IV)

---------**********----------**********----------**********----------

--Login functionality needs to be applied with below data.
--Student ID
--Passoword
--Last login date
--Password Expiration date
--Password reset date
--Account Status (Active/ Pending / Inactive)


Planning - 


##
Placement cell - High level design discussion 

Tables to create
users(students), admins(tpos)

create a sequence to assign student_id - roll_no.

company, drives, placements, login_history, qualifications, resumes(to be implemented after 1st itr)

===========
services 

placement-cell-service(springboot)
/students
/tpos/getelligiblestudent
/login 
/admin-login

placement-cell-ui	(Angular)
Home page
user portal
admin portal


