package com.service;

import com.model.Account;

public interface AccountService {
    Account findById(String username);
}
