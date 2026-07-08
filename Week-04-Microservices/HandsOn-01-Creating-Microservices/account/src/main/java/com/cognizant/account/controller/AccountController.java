package com.cognizant.account.controller;

public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {

        return new Account(
                number,
                "savings",
                234343
        );
    }
}
