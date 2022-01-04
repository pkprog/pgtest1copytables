create sequence SERVICE_ORDER_ID_SEQ as bigint;

alter sequence SERVICE_ORDER_ID_SEQ owned by SERVICE_ORDER.SERVICE_ORDER_ID;
