insert into album (id, title)
values  (1, 'Album 1'),
        (2, 'Album 2'),
        (3, 'Album 3');

insert into artist (id, name)
values  (1, 'Artist 1'),
        (2, 'Artist 2'),
        (3, 'Artist 3');

insert into genre (id, name)
values  (1, 'Genre 1'),
        (2, 'Genre 2'),
        (3, 'Genre 3'),
        (4, 'Genre 4');

insert into playlist (id, title)
values  (1, 'Playlist 1'),
        (2, 'Playlist 2'),
        (3, 'Playlist 3');

insert into song (id, title, album_id, genre_id)
values  (1,     'Song 1',   1,  1),
        (2,     'Song 2',   1,  1),
        (3,     'Song 3',   1,  1),
        (4,     'Song 4',   1,  1),
        (5,     'Song 5',   2,  2),
        (6,     'Song 6',   2,  2),
        (7,     'Song 7',   2,  2),
        (8,     'Song 8',   2,  3),
        (9,     'Song 9',   3,  3),
        (10,    'Song 10',  3,  4),
        (11,    'Song 11',  3,  4),
        (12,    'Song 12',  3,  4);

insert into song_authorship (artists_id, songs_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7),
       (1, 8),
       (3, 8),
       (2, 9),
       (1, 10),
       (1, 11),
       (1, 12),
       (2, 12),
       (3, 12);

insert into album_authorship (artists_id, albums_id)
values (1, 1),
       (2, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (1, 3),
       (2, 3);

insert into song_by_playlist (playlists_id, songs_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 2),
       (3, 7),
       (3, 8),
       (3, 9),
       (3, 10),
       (3, 11),
       (3, 12);