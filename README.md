# 🧪 Swag Labs E2E Automation Project

Automation testing project for [www.saucedemo.com](https://www.saucedemo.com)  
Tech stack includes Selenium, Java, TestNG, and Allure.

---

## 📁 Project Structure

```

src
├── main
│   └── java
├── test
│   └── java
│       ├── base       # BaseTest setup
│       ├── page       # All Page Object Classes
│       └── tests      # TestNG Test Classes

````

---

## 🧰 Tech Stack

| Tool        | Description             |
|-------------|--------------------------|
| Selenium 4  | Browser automation       |
| Java        | Programming language     |
| TestNG      | Test execution           |
| Allure      | Test reporting           |

---

## ▶️ How to Run the Tests

```bash
allure generate allure-results --clean -o allure-report
allure open allure-report
````

---

## ✅ Test Scenarios

* User can log in
* Add product to cart
* Proceed to checkout
* Complete the order

---

## 🏷️ Allure Annotations Used

* `@Epic`
* `@Feature`
* `@Story`
* `@Severity`
* `@Test`
* `@Description`

---

## 🔐 Test Credentials

```
username: standard_user
password: secret_sauce
```

---

## 🚧 Improvement Ideas

* // TODO: Testing all username credentials functionality

---

## 💬 Inquiries?

If you have any inquiries, feel free to keep in touch.