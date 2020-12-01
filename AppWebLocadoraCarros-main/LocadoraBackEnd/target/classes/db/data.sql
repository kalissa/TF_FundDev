INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('IXC2030', 'Volvo', 'XC60', true, true, true, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('WEO3012', 'Volvo', 'XC40', true, true, false, true);false

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('CAS4323', 'Volkswagem', 'Golf', true, true, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('POS5420', 'Chevrolet', 'Chevete', false, false, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('TYR3084', 'Volkswagem', 'Jetta', true, true, true, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('ASQ4932', 'AUDI', 'A4', true, true, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('ZXC2391', 'AUDI', 'A6', true, true, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('EUD2930', 'AUDI', 'R8', true, true, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('AQW2843', 'FERRARI', 'Enzo', true, true, false, true);

INSERT INTO carro (placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponibilidade) 
VALUES ('LVK2039', 'FERRARI', 'California', true, true, false, true);


INSERT INTO Locacoe (inicioLocacao,fimLocacao,carro,subtotal,desconto,seguro,valorFinal,fechada) 
VALUES ('2020-11-20', '2020-11-28', 'LVK2039', 1050, 110,25, 52.5, 992.25, true);

INSERT INTO Locacoe (inicioLocacao,fimLocacao,carro,subtotal,desconto,seguro,valorFinal,fechada) 
VALUES ('2020-11-20', '2020-12-22', 'EUD2930', 2550, 267.75, 127.5, 2.282.25, true);

INSERT INTO Locacoe (inicioLocacao,fimLocacao,carro,subtotal,desconto,seguro,valorFinal,fechada) 
VALUES ('2020-11-19', '2020-12-05', 'POS5420', 1600, 168, 80, 1.512, true);
