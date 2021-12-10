INSERT INTO treat (id, name, image_url, price, bulk_pricing)
VALUES
       (1, 'Brownie', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHdr1eTXEMs68Dx-b_mZT0RpifEQ8so6A1unRsJlyJIPe0LUE2HQ',
        2.00, '{"amount": 4, "totalPrice": 7.00}'::json),
       (2, 'Key Lime Cheesecake', 'http://1.bp.blogspot.com/-7we9Z0C_fpI/T90JXcg3YsI/AAAAAAAABn4/EN7u2vMuRug/s1600/key+lime+cheesecake+slice+in+front.jpg',
        8.00, 'null'::json),
       (3, 'Cookie', 'http://www.mayheminthekitchen.com/wp-content/uploads/2015/05/chocolate-cookie-square.jpg',
        1.25, '{"amount": 6, "totalPrice": 6.00}'::json),
       (4, 'Mini Gingerbread Donut', 'https://s3.amazonaws.com/pinchofyum/gingerbread-donuts-22.jpg', 0.50, 'null'::json);

INSERT INTO sale (id, treat_id, count, price, time, repeat)
VALUES
       (1, 3, 8, 6.00, 'FRIDAYS', true),
       (2, 2, 1, 6.00, '10-01', true),
       (3, 4, 2, 0.50, 'TUESDAYS', true);