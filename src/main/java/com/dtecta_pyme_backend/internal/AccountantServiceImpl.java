package com.dtecta_pyme_backend.internal;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.domain.services.AccountantService;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import com.dtecta_pyme_backend.repositories.AccountantRepository;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantServiceImpl implements AccountantService {

    private final AccountantRepository accountantRepository;

    public AccountantServiceImpl(AccountantRepository accountantRepository) {
        this.accountantRepository = accountantRepository;
    }

    @Override
    public List<Accountant> getAll() {
        return accountantRepository.findAll();
    }

    @Override
    public Accountant create(CreateAccountantResource resource) {
        var newAccountant = new Accountant(resource);
        return accountantRepository.save(newAccountant);
    }

    @Override
    public Accountant update(Long accountantId, UpdateAccountantResource resource) {
        var foundedAccountant =  this.accountantRepository.findById(accountantId)
                .orElseThrow(() -> new NotFoundException("Not found accountant with id: "+ accountantId));

        var updateAccountant = foundedAccountant.updateAccountant(resource);

        return accountantRepository.save(updateAccountant);
    }

    @Override
    public void delete(Long accountantId) {
        var foundedAccountant =  this.accountantRepository.findById(accountantId)
                .orElseThrow(() -> new NotFoundException("Not found accountant with id: "+ accountantId));

        accountantRepository.delete(foundedAccountant);
    }
}
