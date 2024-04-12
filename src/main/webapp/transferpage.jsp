<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>J Bank - Transfer Funds</title>
<link rel="stylesheet" href="./css/dash.css">
</head>
<body>
<header>
  <h1>J Bank</h1>
  <a href="logout" class="logout">Logout</a>
</header>

<div class="body-div">
  <section class="main-container">
    <form action="transfer" method="post" class="balance-div" id="transfer-form">
      <h3>Transfer Funds</h3>
      <div>
        <label for="account-number">Account Number:</label><br>
        <input type="text" id="account-number" name="ac" required><br><br>
      </div>
      <div>
        <label for="amount">Amount:</label><br>
        <input type="text" id="amount" name="amount" required><br><br>
      </div>
      <div>
        <button type="submit" class="button-submit" id="submit-btn" disabled>Submit</button>
      </div>
    </form>

    <div class="spacer"></div>

    <div class="button-container-div">
      <h2>Actions</h2>
      <a href="dashboard.jsp" class="button">Dashboard</a>
    </div>
  </section>
</div>

<div class="spacer-tall"></div>

<footer>
  <p>&copy; J Bank 2024</p>
</footer>

<script>
document.addEventListener('DOMContentLoaded', function() {
  const accountNumberInput = document.getElementById('account-number');
  const amountInput = document.getElementById('amount');
  const submitButton = document.getElementById('submit-btn');

  // Function to check if both inputs have values
  function checkInputs() {
    if (accountNumberInput.value.trim() !== '' && amountInput.value.trim() !== '') {
      submitButton.disabled = false;
    } else {
      submitButton.disabled = true;
    }
  }

  // Event listeners to check inputs on keyup
  accountNumberInput.addEventListener('keyup', checkInputs);
  amountInput.addEventListener('keyup', checkInputs);
});
</script>

</body>
</html>
