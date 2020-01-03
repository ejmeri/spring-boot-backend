package com.curse.shared.domain.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.curse.business.clientes.control.ClientService;
import com.curse.business.clientes.dto.ClientDTO;
import com.curse.business.clientes.entity.Client;
import com.curse.shared.domain.errors.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClientDTO> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ClientService clienteService;

    @Override
    public void initialize(final ClientUpdate ann) {

    }

    @Override
    public boolean isValid(final ClientDTO objDto, final ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        final Map<String, String> map = (Map<String, String>) httpServletRequest
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        objDto.setId(Integer.parseInt(map.get("id")));

        final List<FieldMessage> list = new ArrayList<>();

        final Client existsClient = this.clienteService.findbyEmail(objDto.getEmail());

        if (existsClient != null) {
            if (objDto.getId() != existsClient.getId()) {
                list.add(new FieldMessage("email", "Email já cadastrado"));
            }
        }

        for (final FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}