package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class used to generate a random name for a Solar System or planet
 */
class Names implements Serializable {

    /**
     * Array of 1000 random names
     */
    private static final String [] names = {"Acamar",
            "Acotera","Acunov","Adahn","Ademia","Adilea","Ahines",
            "Aicarro","Aldea","Aliatis","Almeshan","Alvomia","Alvuter",
            "Andeonope","Andevian","Andoinov","Anides","Ankualea","Annippe",
            "Antedi","Anzosie","Astreuphus","Astrurn","Atheavis","Athoria",
            "Athyria","Atis","Atune","Azoalara","Babbara","Bacrars",
            "Baenope","Baethea","Baicarro","Balnitania","Balosnee","Baratas",
            "Beaphus","Becruliv","Bedaotov","Bendulea","Benrarth","Beoyama",
            "Berocury","Bezahiri","Bianus","Biapra","Bidocarro","Bitaliv",
            "Bithaovis","Bitholea","Bithuimia","Bivichi","Biyitis","Bobbiri",
            "Bochone","Bodinus","Bodriayama","Bogunides","Boilea","Boinope",
            "Bolluruta","Bonduzuno","Boorilia","Bradohiri","Braoter","Brax",
            "Bretel","Brichinus","Brizothea","Broegantu","Brubonia","Brudovis",
            "Bruhothea","Buatania","Bulucury","Bunrolla","Buzuno","Cabiyama",
            "Cadus","Caeruta","Calmeron","Calondia","Calviea","Campor",
            "Caorus","Capelle","Carzon","Castor","Cathater","Cavenia",
            "Cazuna","Cearus","Ceatera","Cebberus","Cegunus","Cemanope",
            "Cendapus","Cenvater","Cenvosie","Ceoter","Cerilia","Cesomia",
            "Cestrumia","Cestus","Ceutis","Cexotov","Chadetera","Chalrerth",
            "Chanzagua","Chaoruta","Charlotte","Chastryria","Chathosie","Chatov",
            "Chaverth","Chegrone","Chenone","Chephorth","Cheron","Cheter",
            "Chetrion","Cheutis","Cheuyama","Chiethea","Chilia","Chinkalara",
            "Chinkinov","Chinoyama","Chithea","Chitrao","Chixehiri","Chixoclite",
            "Chiyama","Choater","Chobrubos","Chokaphus","Cholmaewei","Chonypso",
            "Chomepra","Chonkatania","Chophitera","Chosunerth","Chubbeon","Chueclite",
            "Chumolea","Ciaruta","Cibrauyama","Cibreunides","Cichatania","Cichunerth",
            "Cinus","Cinzealara","Cinzillon","Ciothea","Cipuclite","Cisaiphus",
            "Coater","Cognolla","Coihiri","Coirus","Cokamia","Colalara",
            "Colnomia","Conarvis","Coopra","Couhiri","Courteney","Craeyama",
            "Cralistea","Craotune","Cratinus","Credurilia","Crixotis","Croestea",
            "Crononia","Cruotera","Cryria","Cuanope","Cubbion","Cubbuatune",
            "Culea","Cuziyama","Culrilles","Cuoria","Dachuliv","Dagruria",
            "Dahaturn","Daleclite","Daled","Damast","Dapelea","Dastrorix",
            "Davlos","Debrinov","Delriuq","Delrurn","Deneb","Deneva",
            "Dethevis","Devidia","Devinov","Dezenerth","Dillialea","Dinvihines",
            "Dionope","Dipheron","Dirilia","Diunope","Divis","Doaria",
            "Dobenerth","Docheoyama","Dollater","Doloter","Donus","Dopelara",
            "Dosone","Dothathea","Dothiwei","Drabanus","Dradalia","Draylon",
            "Dreciturn","Drema","Dresetania","Dreyahiri","Drezewei","Dritutania",
            "Driveter","Dromeruta","Drosotov","Dubone","Dugantu","Dugniri",
            "Dugnorix","Duhines","Duhulea","Dukihiri","Duzavis","Eathea",
            "Eatis","Ebrade","Ecavis","Echonoe","Ecrarth","Ecury",
            "Edyria","Eirilia","Eitania","Eivis","Elmichi","Elmoamia",
            "Elnainus","Emilia","Emuathea","Endor","Endorix","Enirilia",
            "Enkonoe","Ennoria","Enverth","Enzanerth","Esmee","Estrapus",
            "Estriastea","Estronoe","Esurn","Eumia","Exo","Ezillon",
            "Ferris","Festen","Fourmi","Frolix","Gabetis","Gabremia",
            "Gadetis","Gaolia","Gaoliv","Garanus","Gebronov","Geccuna",
            "Gedatune","Gelrorix","Gemulon","Gephone","Gevaizuno","Geyama",
            "Gibbarth","Gicrazuno","Gicrilara","Giethea","Gilniozuno","Giutis",
            "Gnaaliv","Gnabuhines","Gnabuthea","Gnethetania","Gnituturn","Gnixanope",
            "Gnodonope","Gnodonus","Gnopolara","Gnounus","Gnoxinov","Gnudetune",
            "Gnuxenides","Goccenia","Godayama","Gognoter","Golraitania","Gomorix",
            "Gorus","Gostrion","Gotrionov","Gotrubos","Goturn","Gougawa",
            "Gozipra","Gracheyama","Grechanus","Greonus","Grimemia","Groacarro",
            "Groluter","Grudeliv","Gruthetune","Guastea","Gubradus","Guephus",
            "Guhines","Guinifer","Guistea","Gukotov","Gulara","Gulmichi",
            "Gunzade","Hades","Hadrebos","Hadunia","Haeria","Hagawa",
            "Hagralara","Halmonides","Hamlet","Hangacury","Hankides","Heatis",
            "Hechone","Helena","Hendieliv","Hichezuno","Hidosie","Hiphautera",
            "Hitrenia","Hivilles","Hizuno","Hoclite","Hogantu","Honvuna",
            "Hulea","Hulia","Hulst","Hunrilia","Huvoiruta","Ianov",
            "Ibbippe","Iboutera","Ibrara","Ibrypso","Ichaoruta","Ichinda",
            "Icrypso","Idrarth","Ieria","Ililia","Ilionov","Ilneron",
            "Ingippe","Ingoarilia","Iniaphus","Inides","Innuna","Inov",
            "Inreiter","Inzeitis","Inzion","Iodine","Iolia","Ioyama",
            "Iralius","Isara","Isore","Istrora","Iter","Itera",
            "Itholla","Ithurn","Itov","Iuvis","Janus","Japori",
            "Jarada","Jason","Kabos","Kacrevis","Kagaenope","Kamia",
            "Kanerth","Kanov","Kaphiacury","Kastea","Katurn","Kawei",
            "Kaylon","Keccagua","Kenrarvis","Keunus","Keutera","Khefka",
            "Kieturn","Kira","Kithurn","Klaatu","Klaestron","Kocury",
            "Koistea","Kolorilia","Korma","Kosagawa","Kravat","Krios",
            "Kuetis","Kulvion","Kutune","Ladetania","Ladinda","Laertes",
            "Lailiv","Largo","Later","Lave","Lecutania","Lelea",
            "Leliv","Lengurus","Lenzolla","Lestrarth","Lestrion","Lesurn",
            "Levurus","Lezacarro","Libbilles","Libegawa","Liccade","Lidilia",
            "Lienia","Lienides","Ligalara","Ligon","Lilea","Limilles",
            "Liomia","Lioter","Llamavis","Llerenides","Llerinov","Llexatune",
            "Llihoter","Llilastea","Lloduvis","Lloyetis","Lluocarro","Loayama",
            "Lobiunia","Longarvis","Lonreliv","Lotune","Lowry","Lubroiter",
            "Lukerilia","Lullov","Lunuclite","Mabbilles","Mabos","Macadus",
            "Maceon","Machavis","Magrat","Malcoria","Malnonoe","Manarth",
            "Manueter","Maphore","Maubos","Maurilia","Megnaogawa","Meithea",
            "Melina","Mentar","Menzabos","Meotis","Merik","Mestea",
            "Metruinov","Meyama","Mibosie","Miditov","Miestea","Minerilia",
            "Minkillon","Mintaka","Mioturn","Misiria","Mivowei","Mochiunerth",
            "Mochotov","Mogrutis","Mondatania","Montor","Moputov","Mordan",
            "Moreturn","Moter","Motronoe","Moumia","Movutis","Moyama",
            "Mozipra","Muanides","Mubov","Mubromia","Muiclite","Munnastea",
            "Munope","Munvarvis","Muruta","Muteturn","Muturn","Myrthe",
            "Nagaphus","Nahebos","Naothea","Nasehines","Natrilia","Nebaclite",
            "Neccaugawa","Necroth","Nedurn","Nelia","Neluiturn","Nelvana",
            "Neperuta","Nexuclite","Nibbagua","Nidatune","Nilaturn","Nisunia",
            "Nix","Noaphus","Nocutune","Nohines","Noicarro","Nolara",
            "Nolelara","Nolneshan","Nonnyke","Nothaewei","Notov","Nubatania",
            "Nubbiruta","Nucruthea","Nuguvis","Nuhabos","Nundizuno","Nundov",
            "Nunrehines","Nunus","Nyle","Oaturn","Obahiri","Obaliv",
            "Obuinerth","Obuna","Oclite","Ocribos","Odet","Og",
            "Ohines","Olagua","Ollezuno","Ollolla","Olmeuturn","Ololla",
            "Olrizuno","Omega","Omphalos","Onditune","Onerth","Onillon",
            "Onrore","Onveotis","Onzoatov","Onzuegawa","Orias","Oruta",
            "Ostea","Oter","Otera","Othello","Oturn","Oyama",
            "Pagiri","Palmuhines","Palvilia","Parade","Pecceshan","Peinides",
            "Penthara","Penzonoe","Pestea","Pethuter","Phatonerth","Phedania",
            "Phenahines","Phieclite","Phion","Phuzunia","Picard","Pievis",
            "Piophus","Piphayama","Pobippe","Pollotania","Pollux","Pomia",
            "Ponosie","Pouthea","Pubrars","Pubrathea","Pundosie","Pungaria",
            "Punides","Punus","Putrapus","Quator","Raclite","Raiter",
            "Rakhar","Ran","Rathatera","Raumia","Regulas","Relniphus",
            "Relva","Renonides","Rephorix","Reunia","Rhymus","Ribosie",
            "Rillion","Rithyria","Riunerth","Robbaustea","Rochani","Roliv",
            "Rolnaeria","Ronerth","Ronzeshan","Ruacury","Rubicum","Rubigawa",
            "Rubruna","Rudrao","Rudromia","Rulazuno","Rulnoiwei","Rundilles",
            "Ruter","Rutia","Ruwei","Saaclite","Saccarth","Sachuliv",
            "Sadriri","Saephus","Sagantu","Sagriea","Salolla","Salrade",
            "Sarpeidon","Sathetov","Sefalla","Segantu","Seltrice","Semizuno",
            "Seniter","Senkolla","Senziea","Seoliv","Sepra","Sexucarro",
            "Sigma","Siinus","Silmuehiri","Sinulara","Sinzeshan","Siphiarus",
            "Siphonus","Siuzuno","Siyama","Soahines","Soccialea","Soicarro",
            "Sol","Solea","Solmaogawa","Somari","Sonvunia","Soregantu",
            "Sounope","Stakoron","Straahines","Straviter","Straxaliv","Strerovis",
            "Strivagantu","Strixohines","Strumohiri","Struxeclite","Styris","Succalia",
            "Sucheogantu","Suebos","Suenope","Suipra","Sulneoria","Sumia",
            "Sunosie","Sunzonoe","Suxerus","Tabypso","Tacuenus","Tadruarus",
            "Taenope","Taibos","Talani","Tallippe","Tamus","Tantalos",
            "Tanuga","Tarchannen","Teahines","Temuayama","Tengade","Tenkichi",
            "Tennelea","Tenrillon","Teolara","Terosa","Thacuvis","Thaiter",
            "Thamutov","Thanzoria","Thapatov","Thater","Thatrypso","Thaxoter",
            "Thedriuliv","Thegawa","Thelea","Themuwei","Thenov","Thera",
            "Thetonia","Theviclite","Thiatov","Thillewei","Thilnoinus","Thilrore",
            "Thindainia","Thindichi","Thipinope","Thistrupra","Thivaozuno","Thochars",
            "Tholion","Tholrillon","Tholvonoe","Thonkarilia","Thosarth","Thuastea",
            "Thuccitov","Thuchorth","Thudore","Thugantu","Thugiter","Thulmomia",
            "Thunia","Thunitune","Thuphyria","Thuziurilia","Tidraitune","Tinkietania",
            "Tinretov","Titan","Toberon","Tobrion","Togratis","Tonides",
            "Torin","Tostradus","Toter","Totryke","Tramiyama","Trazeter",
            "Trenuwei","Tresupra","Treucarro","Triacus","Trileruta","Tripaphus",
            "Troahines","Trobilia","Troegawa","Trovatov","Troviria","Trucunus",
            "Trudirus","Truonia","Trusetera","Truvinus","Tuilia","Tuliv",
            "Tulnicarro","Tunnyria","Turkana","Tyrus","Uahiri","Uavis",
            "Ubbeatune","Uccuter","Uchenov","Uestea","Ugnore","Uibos",
            "Uihiri","Uimia","Ulea","Ulmerilia","Ulmypso","Ulnaria",
            "Ulnorth","Ulveuter","Umberlee","Undao","Unkalara","Unkielea",
            "Unkiri","Unvaunope","Uphara","Usourilia","Uter","Utopia",
            "Utramia","Utrilara","Utune","Uturn","Vadera","Vaenerth",
            "Vagra","Vandor","Vaobos","Vatov","Vauvis","Vavis",
            "Vayutis","Vecetis","Vegiri","Vegolla","Vemia","Ventax",
            "Veocury","Vephiuwei","Vestruibos","Vethezuno","Veyiter","Viclite",
            "Vieyama","Vihines","Vimov","Viniacarro","Vinvars","Viophus",
            "Visoria","Visunov","Visyria","Vithea","Viuliv","Voatis",
            "Volutune","Volvapra","Volvichi","Vonope","Vonoth","Vuanus",
            "Vubbaoyama","Vubiea","Vubos","Vucriri","Vulemia","Vumonoe",
            "Vunion","Vutewei","Xatania","Xaerilia","Xangunov","Xebahiri",
            "Xebeshan","Xenon","Xenzaitov","Xerxes","Xethea","Xiaphus",
            "Xibbogantu","Xinus","Xithomia","Xochayama","Xodeon","Xograo",
            "Xoitune","Xoliugawa","Xophestea","Xugrionope","Xunides","Xutov",
            "Yagnomia","Yagreiruta","Yalea","Yameron","Yebburn","Yecciea",
            "Yeccov","Yedorix","Yendeon","Yenvion","Yeruta","Yew",
            "Yigara","Yilniophus","Yindov","Yinus","Yinzilia","Yithone",
            "Yodars","Yojimbo","Yonriea","Yonzienus","Yubbetune","Yubreshan",
            "Yuenerth","Zaerus","Zaewei","Zalkon","Zanonus","Zaruta",
            "Zauthea","Zeanov","Zebberilia","Zecetune","Zechater","Zegnuruta",
            "Zeicury","Zeturn","Zeutune","Zevulia","Zicutune","Zienope",
            "Zilater","Zimawei","Zippe","Zithea","Zithenus","Zitune",
            "Zoetis","Zognourus","Zolitania","Zolonerth","Zorus","Zoxonerth",
            "Zubroth","Zucury","Zudao","Zulmioturn","Zunanus","Zunnerth",
            "Zuphade","Zuregawa","Zuul"};

    /**
     * List of unused names from the random array.
     */
    private static final List<String> unusedNames = new ArrayList<>(Arrays.asList(names));

    /**
     * Number used if all names are used
     */
    private static int count;

    /**
     * Gets a random name from the list, or a number if all 1000 names are used.
     * @return random name unique from all other names.
     */
    public static String getName() {
        if (!unusedNames.isEmpty()) {
            int random = (int)(Math.random() * unusedNames.size());
            return unusedNames.remove(random);
        } else {
            String result = "" + count;
            count++;
            return result;
        }
    }
}
