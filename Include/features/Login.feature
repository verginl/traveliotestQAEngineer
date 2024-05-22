@Auth
Feature: Auth

  @LoginSukses
  Scenario: Login sukses
    Given User berada di halaman login
    When User input email "verginl26051@gmail.com" dan password "Password1234"
    And user klik button masuk
    Then Berhasil masuk ke halaman beranda
    
  @LoginGagal
  Scenario: Login gagal
    Given User berada di halaman login
    When User input email "verginl26051@gmail.com" dan password "Passwordsalah"
    And user klik button masuk
    Then Menampilkan popup gagal login