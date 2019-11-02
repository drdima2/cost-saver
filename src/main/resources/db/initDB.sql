DROP TABLE IF EXISTS product;

create table if not exists product
(
	id serial not null
		constraint product_pkey
			primary key,
	barcode text not null,
	productname text not null
)
;
