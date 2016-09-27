create table KLIENT 
  (
  id number,
  imie varchar(30),
  nazwisko varchar(40),
  telefon number,
  constraint pk_id primary key(id)
  );
  
  create table MAGAZYN 
  (
  id_magaz number,
  adres varchar(40),
  ilosc_wsz_lekow number,
  ilosc_dost_lekow number,
  constraint pk_id1 primary key(id_magaz)
  );
  
  create table SZPITAL
  (
  id number,
  adres varchar(40),
  nazw_ordynatora varchar(40),
  constraint pk_id2 primary key(id)
  );
  
  create table APTEKA
  (
  id_szpital number,
  numer number,
  adres varchar(40),
  constraint pk_id3 primary key(numer),
  constraint fk_id foreign key(id_szpital)
  references SZPITAL(id)
  );
  
  create table PRACOWNIK
  (
  numer_apteki number,
  pesel number,
  imie varchar(30),
  nazwisko varchar(40),
  stanowisko number,
  constraint pk_id4 primary key(pesel),
  constraint fk_id2 foreign key(numer_apteki)
  references APTEKA(numer)
  );
  
  create table LEKI
  (
  nazwa varchar(30),
  rodzaj varchar(30),
  id_klienta number,
  id_magazynu number,
   constraint pk_id5 primary key(nazwa),
  constraint fk_id3 foreign key(id_klienta)
  references KLIENT(id),
  constraint fk_id4 foreign key(id_magazynu)
  references MAGAZYN(id_magaz)
  );
  
  create table RECEPTA
  (
  numer number,
  nazwisko_lekarza varchar(40),
  nazwa_lek varchar(30),
  constraint pk_id6 primary key(numer),
  constraint fk_id5 foreign key(nazwa_lek)
  references LEKI(nazwa)
  );
  
  create table KLIENT_PRACOWNIK
  (
  id_klienta number,
  pesel_prac number,
  constraint pk_id7 primary key(id_klienta, pesel_prac),
  constraint fk_id6 foreign key(id_klienta)
  references KLIENT(id),
   constraint fk_id7 foreign key(pesel_prac)
  references PRACOWNIK(pesel)
  );
  
  create table MAGAZYN_APTEKA
  (
  numer_apteki number,
  id_mag number,
  constraint pk_id8 primary key(numer_apteki, id_mag),
  constraint fk_id8 foreign key(numer_apteki)
  references APTEkA(numer),
   constraint fk_id9 foreign key(id_mag)
  references MAGAZYN(id_magaz)
  );
  
  
  
  