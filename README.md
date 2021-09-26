# Patient Onboarding Web Application

### Result (Home Page) :
![](https://github.com/Na-veed/Patient-OnBoarding-Angular/blob/master/src/assets/home.JPG)
### Note :
  This project is only spring project and please find related angular project [here](https://github.com/PavanSaiSheshetti/PatientOnboardingApp_Angular). You will find complete 
  description of running project in Installation and Run Section
## Project Description

Title of our application is patient on-boarding app

The Application allows patients to submit and update patient information and store it securely making on- boarding faster and reliable.Patient can also buy medicines allocated by the doctor.

Doctor can Login and get all the appointments registered under him and can also allocate medicines to patient. Admin can add the doctors, medicines and have the control over the whole application.

## Technologies Used

<ul><li>Java
  <li>Java
  <li>Angular
  <li>SpringBoot
  <li>Spring Data
  <li>PostgreSql
  <li>JSON
</ul>

## Features

<p> Title of our application is patient on-boarding app</p>

<p> As the title suggest the main use case of the application is to make an appointment as patient and as an doctor process the appointment</p>

<h3>Use cases and roles</h3>
<H4>As a Patient:</h4>
<ul>
  <li>I can create an account and login to my account and make an appointment with an specialized doctor according to my wish</li>
  <li>I can buy medicines which have been allocated for me from the doctors</li>
  <li>I can view my account and update my account as per my convenience</li>
</ul>
<h4>As a Doctor</h4>
<ul>
  <li>I can login to my account and get the appointments that has been scheduled for me</li>
  <li>I can allocate medicines to a particular patient</li>
  <li>I can view my account and update my account as per my convenience</li>
</ul>
<h4>As an Admin</h4>
<ul>
  <li>I can login to my account and get the all the appointments that has been received</li>
  <li>I can allocate medicines to a particular patient and also get all the medicines that has been allocated to patients</li>
  <li>I can add doctors and delete doctors</li>
  <li>I can able to delete patients and delete the records of medicines that been in the bought state
</ul>

### Technical Aspect:

<ul>
<li>Used Spring Data for connecting to postgresql database </li>
<li>Used DAO design pattern in the project
<li>Created Interactive Webpages using Angular and Bootstrap for the website
<li>All the client side and server side validations were done using TypeScript and Database
<li>Exception or Error Handling is done in both  java and angular(With HttpClient)
<li>Tested all the functionalities using JUnit4 
<li>Implemented Logging by Log4j
</ul>

## Getting Started

After running this project , run the angular project (import angular project [here](https://github.com/PavanSaiSheshetti/PatientOnboardingApp_Angular)). Homw page will be displayed where you can see the about and facilities section about the hospital. And also customer can register and login, Doctor and admin can login.

Customer can make an appointment with the specified doctor after login, and can view and update profile, Also buy medicine. Dotor can view his/her appointments, can also allocate medicines. Admin can add doctor, medicines and have control over the whole functionalities

## Usage

### Step1 :
Import this project by a Github Desktop(click [here](https://desktop.github.com/) to install) or by downloading the Zip file . If you downloaded the zip file then you need to unzip or extract it and import this in eclipse(file-->import-->select the project)
change the database configuration in application.properties file (Driver,Dialect,username and password).

### Step2 :
Import the angular Project (find [here](https://github.com/PavanSaiSheshetti/PatientOnboardingApp_Angular))by a Github Desktop or by downloading the Zip file. If you downloaded the zip file then you need to unzip or extract it and open the project folder in visual studio code or any other code editor(file-->select folder-->select the project)

That's all you can run this project and see the results.

###### Note :
<ol>
<li>you can install eclipse IDE <a href="https://www.eclipse.org/downloads/">here</a></li>
<li>you can install visual studio code <a href="https://code.visualstudio.com/download">here</a></li>
</ol>

## Contributors :

This is a project of team 4 members . we collabortively worked together to complete the project

### Bug / Feature Request:

If you find a bug (the website couldn't handle the query and / or gave undesired results), kindly open an issue [here](https://github.com/PavanSaiSheshetti/PatientOnboardingApp_Web/issues/new) by including your search query and the expected result.
