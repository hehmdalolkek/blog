insert into users (id, username, password, registration_date)
values (uuid_to_bin('bc52cbf1-16f5-4e20-9975-2b26cfefcb8f', true), 'user1',
        '$2a$12$vBE/f76b9ITmCTDL0xVsz.Sz/8ktxR23/LBEy/bJSxnLfoxSyGGbW', now()),
       (uuid_to_bin('29a5af6a-9067-443e-beaa-613541468d00', true), 'user2',
        '$2a$12$OgYrY5q5vDvnaKZbDNGJcOch9Y99lUerxayPY5lZmM/6FovG78uui', now()),
       (uuid_to_bin('bf1d1c02-b163-4d5a-a69f-48409699803a', true), 'user3',
        '$2a$12$cRg9vi1xkJzqgXvlirxtT.Ib4gLuDURHqFWvI/0ZAcaVSjjbRTADS', now()),
       (uuid_to_bin('235ad8fb-9046-453a-ae70-0ead8b9784e9', true), 'user4',
        '$2a$12$LydgL6tlj.0cI4wl9fLudOzI8LmASWRZZWvqz6SNj.ZcnVUdpuGFq', now());

insert into users_roles (user_id, role)
values (uuid_to_bin('bc52cbf1-16f5-4e20-9975-2b26cfefcb8f', true), 'AUTHOR'),
       (uuid_to_bin('29a5af6a-9067-443e-beaa-613541468d00', true), 'AUTHOR'),
       (uuid_to_bin('bf1d1c02-b163-4d5a-a69f-48409699803a', true), 'AUTHOR'),
       (uuid_to_bin('bf1d1c02-b163-4d5a-a69f-48409699803a', true), 'ADMIN'),
       (uuid_to_bin('235ad8fb-9046-453a-ae70-0ead8b9784e9', true), 'AUTHOR');

insert into posts (id, title, content, author_id, creation_date)
values (uuid_to_bin('7b96bf22-7722-47a6-a8bf-687039d6b61c', true),
        'title1',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('bc52cbf1-16f5-4e20-9975-2b26cfefcb8f', true),
        now()),
       (uuid_to_bin('a060de0e-bd74-4425-857c-94ccd6356aa9', true),
        'title2',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('235ad8fb-9046-453a-ae70-0ead8b9784e9', true),
        now()),
       (uuid_to_bin('b600c4a1-1e85-4726-b3f0-9501e7fa5080', true),
        'title3',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('235ad8fb-9046-453a-ae70-0ead8b9784e9', true),
        now()),
       (uuid_to_bin('bf77d14e-1276-4a7d-9904-f0765c0034a8', true),
        'title4',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('bc52cbf1-16f5-4e20-9975-2b26cfefcb8f', true),
        now()),
       (uuid_to_bin('f5b19de7-77cd-4131-9266-f96aa46a35c2', true),
        'title5',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('235ad8fb-9046-453a-ae70-0ead8b9784e9', true),
        now()),
       (uuid_to_bin('b6c9a55e-5d6f-45f9-8f19-bd5a9beebbe5', true),
        'title6',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('bc52cbf1-16f5-4e20-9975-2b26cfefcb8f', true),
        now()),
       (uuid_to_bin('3fd60138-8420-4896-8f31-c4503c4815ab', true),
        'title7',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        uuid_to_bin('bf1d1c02-b163-4d5a-a69f-48409699803a', true),
        now());