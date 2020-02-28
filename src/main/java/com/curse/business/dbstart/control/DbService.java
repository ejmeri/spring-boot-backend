package com.curse.business.dbstart.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.curse.business.addresses.control.AddressRepository;
import com.curse.business.addresses.control.CityRepository;
import com.curse.business.addresses.control.StateRepository;
import com.curse.business.addresses.entity.Address;
import com.curse.business.addresses.entity.City;
import com.curse.business.addresses.entity.State;
import com.curse.business.categories.control.CategoryRepository;
import com.curse.business.categories.entity.Category;
import com.curse.business.clientes.control.ClientRepository;
import com.curse.business.clientes.entity.Client;
import com.curse.business.clientes.enums.ClientType;
import com.curse.business.orders.control.OrderItemRepository;
import com.curse.business.orders.control.OrderRepository;
import com.curse.business.orders.entity.Order;
import com.curse.business.orders.entity.OrderItem;
import com.curse.business.payments.control.PaymentRepository;
import com.curse.business.payments.entity.BillPayment;
import com.curse.business.payments.entity.CardPayment;
import com.curse.business.payments.entity.Payment;
import com.curse.business.payments.enums.StatusPayment;
import com.curse.business.products.control.ProductRepository;
import com.curse.business.products.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void instantiateTestDatabase() throws ParseException {
        Category cone = new Category(null, "Informática");
		Category ctwo = new Category(null, "Escritório");
		Category cthree = new Category(null, "Eletrodoméstico");
		Category cfour = new Category(null, "Categoria Teste");

		Product pone = new Product(null, "Computador", 2500.0);
		Product ptwo = new Product(null, "Impressora", 899.0);
		Product pthree = new Product(null, "Mouse", 99.0);
		Product pfour = new Product(null, "Batedeira", 99.0);
		Product pfive = new Product(null, "Liquidificador", 199.9);
		

		cone.getProducts().addAll(Arrays.asList(pone, ptwo, pthree));
		ctwo.getProducts().addAll(Arrays.asList(ptwo, pfour));
		cthree.getProducts().addAll(Arrays.asList(pfour, pfive));

		pone.getCategories().addAll(Arrays.asList(cone));
		ptwo.getCategories().addAll(Arrays.asList(cone, ctwo));
		pthree.getCategories().addAll(Arrays.asList(cone));
		pfour.getCategories().addAll(Arrays.asList(cthree, ctwo));
		pfive.getCategories().addAll(Arrays.asList(cthree));
		

		this.categoryRepository.saveAll(Arrays.asList(cone, ctwo, cthree, cfour));
		this.productRepository.saveAll(Arrays.asList(pone, ptwo, pthree, pfour, pfive));

		State stateOne = new State(null, "São Paulo");
		State stateTwo = new State(null, "Minas Gerais");

		City cityOne = new City(null, "São Paulo", stateOne);
		City cityTwo = new City(null, "Belo Horizonte", stateTwo);
		City cityThree = new City(null, "Campinas", stateOne);

		stateOne.getCities().addAll(Arrays.asList(cityOne, cityThree));
		stateTwo.getCities().addAll(Arrays.asList(cityTwo));

		this.stateRepository.saveAll(Arrays.asList(stateOne, stateTwo));
		this.cityRepository.saveAll(Arrays.asList(cityOne, cityTwo, cityThree));

		Client client = new Client(null, "Elmeri Silva", "elmeri@teste.com", "00912365475", ClientType.PessoaFisica);
		client.getTelephones().addAll(Arrays.asList("912344321", "912344320"));

		Address address1 = new Address(null, "Rua Sei lá", "1", "não tem", "sei laá", "1234321", client, cityOne);
		Address address2 = new Address(null, "Rua Sei lá", "76768", "não tem", "sei laá", "1234321", client, cityOne);

		client.getAddresses().addAll(Arrays.asList(address1, address2));

		this.clientRepository.save(client);
		this.addressRepository.saveAll(Arrays.asList(address1, address2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order orderOne = new Order(null, sdf.parse("30/09/2017 10:32"), client, address1);
		Order orderTwo = new Order(null, sdf.parse("30/09/2017 10:32"), client, address2);

		Payment cardPayment = new CardPayment(null, StatusPayment.QUITADO, orderOne, 6);
		orderOne.setPayment(cardPayment);

		Payment billPayment = new BillPayment(null, StatusPayment.PEDENTE, orderTwo, sdf.parse("30/09/2017 10:32"),
				null);
		orderTwo.setPayment(billPayment);

		client.getOrders().addAll(Arrays.asList(orderOne, orderTwo));
		this.orderRepository.saveAll(Arrays.asList(orderOne, orderTwo));
		this.paymentRepository.saveAll(Arrays.asList(cardPayment, billPayment));

		OrderItem orderItemOne = new OrderItem(orderOne, pone, 0.00, 1, 2000.00);
		OrderItem orderItemTwo = new OrderItem(orderOne, pthree, 0.00, 2, 80.00);
		OrderItem orderItemThree = new OrderItem(orderTwo, ptwo, 0.00, 7, 239.9);

		orderOne.getItems().addAll(Arrays.asList(orderItemOne, orderItemTwo));
		orderTwo.getItems().addAll(Arrays.asList(orderItemThree));

		pone.getItems().addAll(Arrays.asList(orderItemOne));
		ptwo.getItems().addAll(Arrays.asList(orderItemThree));
		pthree.getItems().addAll(Arrays.asList(orderItemTwo));

		orderItemRepository.saveAll(Arrays.asList(orderItemOne, orderItemTwo, orderItemThree));
    }
}