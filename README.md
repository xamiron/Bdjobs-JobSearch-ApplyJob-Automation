# Bdjobs-Sign-In-With-Job-Search
The "Bdjobs-Sign-In-With-Job-Search" project leverages the power of Selenium WebDriver and WebDriverManager to automate the process of signing into bdjobs.comand performing job searches.
This project streamlines interactions with the bdjobs.com website, allowing users to log in, conduct multiple job searches with different keywords,and navigate through search results effortlessly.

# Key Features
# Automated Login: 
The script automates the login process, entering the username and password, and navigating through the login steps to access the user's account on bdjobs.com.

# Keyword-Based Job Search:
Once logged in, the script performs job searches based on various keywords, demonstrating its ability to handle multiple search queries in an automated manner.

# Dynamic Waiting Mechanism:
The script uses WebDriverWait to ensure that web elements are interactable before performing actions, enhancing the reliability and robustness of the automation.

# Window Handling:
The script handles multiple browser windows or tabs, allowing seamless switching between different windows during the automation process.

# Code Structure

# Setup: 
Initializes the WebDriver using WebDriverManager, and maximizes the browser window.
# Navigation and Interaction: 
Navigates to bdjobs.com, performs login actions, and conducts job searches based on specified keywords.
# Search Function:
A reusable method (performSearch) is implemented to perform searches with different keywords, making the code modular and easy to extend.
# Cleanup: 
Ensures the browser is closed properly after the automation tasks are completed.
