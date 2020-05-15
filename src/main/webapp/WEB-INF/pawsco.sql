DROP DATABASE IF EXISTS pawsco;
CREATE DATABASE pawsco;
USE pawsco;

CREATE TABLE Categories (
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
Name NVARCHAR (50));

INSERT INTO Categories
(Name) VALUES
('Food'),
('Toys'),
('Furniture'),
('Grooming'),
('Apparel');

CREATE TABLE Products (
ProductID INT PRIMARY KEY AUTO_INCREMENT,
CategoryID INT,
Name NVARCHAR(50),
Description NVARCHAR(1000),
Price DOUBLE(10,2),
ImageFilename NVARCHAR(50),
FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID));

INSERT INTO Products
(CategoryID, Name, Description, Price, ImageFilename) VALUES 
(1, 'Nulo FreeStyle Limited+', 'Have a dog with food sensitivities? Try our FreeStyle Limited+ Puppy & Adult Salmon recipe, which includes patented probiotic GanedenBC30. This probiotic improves digestive and immune health to keep your canine happy and healthy. This single-source protein recipe is made without chicken, chicken fat, eggs, peas, pea fiber, white potato or tapioca, which cuts out a lot of potential allergens allowing your dog to get back to basics when it comes to nutrition.', 74.99, 'nulo.jpg'),
(1, 'Blue Buffalo', 'Real beef, chicken, fish, lamb or turkey dinners made from natural ingredients enhanced with vitamins and minerals, they\'re rich in taste and healthy nutrition.', 3.99, 'blue.jpg'),
(1, 'Kirkland Signature Dental Chews, 72-count', 'Every dog deserves clean teeth! Grain-free and gluten-free dental chews are safely digestible, with no artificial colors, flavors or preservatives. The chews are two-sided, with a groove and multiple levels of ridges and nubs to help clean teeth and reduce plaque and tartar from a variety of angles: the easy "paw-grip" handle is designed to work with your dog\'s natural, instinctive chewing style.', 19.99, 'dental.jpg'),
(2, 'KONG Classic Dog Toy, X-Large', 'The KONG Classic is the gold standard of dog toys and has become the staple for dogs around the world for over forty years. Offering enrichment by helping satisfy dogs\' instinctual needs, the KONG Classic\'s unique all-natural red rubber formula is ultra-durable with an erratic bounce that is ideal for dogs that like to chew while also fulfilling a dog\'s need to play. Want to extend play time? Be sure to stuff with tempting bits of kibble and entice with a dash of peanut butter. Add to the funs by adding KONG Snacks and topping with KONG Easy Treat.', 9.99, 'kong.png'),
(2, 'STAR WARS Darth Vader Rope Dog Toy, Large', 'The Star Wars Darth Vader Rope Dog Toy gets your pup excited to chase him across the galaxy during spirited games of fetch with a loud and exciting squeak. A black and silver braided rope provides a satisfying and beneficial texture to chew on.', 11.99, 'starwars.jpg'),
(2, 'Marvel Deadpool Rubber Dog Toy, Small', 'The Marvel Deadpool Rubber Dog Toy is geared up and ready to rally your dog\'s love for tugging and chasing. A satisfying rubber texture, the soft plush of the red-suited X-Man trainee and a captivating squeaker load up this dog toy for alluring playtime fun.', 6.99, 'deadpool.jpg'),
(3, 'Elegant Wooden Pet Bed', 'Give your pet a pet bed designed with elegance, entirely made of durable wood construction with a beautiful dark brown finish. The elevated design provides good ventilation for your pet to enjoy a comfortable sleep. Easy to assemble. For dogs and cats up to 44 lbs.', 49.99, 'petfurniture.jpg'),
(3, 'Orthopedic Dog Bed', 'Orthopedic base with layer of cooling memory foam for comfort and support 100% recycled polyester fibre filled bolsters Upholstery grade fabric cover with zippers for easy washing Foam base is removable for washing.', 29.99, 'dogbed.jpg'),
(3, 'Studio Dog Crate', 'Designed as a piece of contemporary furniture, it\'s more than just an indoor dog crate. It\'s the perfect compliment to your home and fulfills your dog\'s natural instinct to have a den that they can call their own. It brilliantly solves the issue of where to store all of your dog\'s accessories. The optional closet is a versatile addition to your dog crate furniture and an incredibly practical solution for storing your dog\'s coat, treats, favorite toy and lead all in one handy place.', 89.99, 'dogcrate.jpg'),
(4, 'Nail Clipper', 'These steel pet nail clippers help you quickly and easily trim your dog\'s nails, keeping them comfy and healthy. Long nails can cause your dog discomfort, even pain if they get snagged or infected. With heavy duty dog nail clippers, your dog\'s toes will be safe and healthy. The sharp blade ensures a precise, quick cut that trims the nail rather than crushes it. A precise trim with the dog nail clippers helps you cut just where you want without nicking the quick in the nail.', 4.99, 'nailclipper.jpg'),
(4, 'FURminator Fur Brush', 'The FURminator Undercoat deShedding Tool for dogs reduces loose hair from shedding up to 90% with regular use. The stainless steel deShedding edge reaches through topcoat to safely and easily remove loose hair and undercoat without damaging topcoat or cutting skin when used as directed. Use the FURejector button to release hair with ease, making deShedding easier than ever! The ergonomic handle provides you with comfort, while the curved edge conforms to your pet\'s natural build and shape for their comfort.', 7.99, 'brush.jpg'),
(4, 'Burt\'s Bee Shampoo', 'Bring nature\'s best to your pets with Burt\'s Bees Natural Pet Care. Experience the full line of gentle pet grooming products featuring natural ingredients including honey, chamomile, and lavender. All products are specially formulated for pets, keeping you, your pet and the environment happy.', 4.99, 'burtsbee.jpg'),
(5, 'Rain Coat', 'Imagine how great your dog will feel wearing a waterproof rain jacket that really fits well. Voyagers K9 Apparel stitches quality and style together so your dog gets outdoors in a rain coat with long-lasting comfort. Easy to put on and keep on, our lightweight rain jacket blocks wind and rain so well that you and your dog will be a happier pair! For safety\'s sake, we\'ve added reflective piping along the raincoat\'s lower edge to draw attention to your dog in dark or dreary conditions. If your dog needs a comfortable rain jacket that fits, order today...your pup will thank you!', 19.99, 'raincoat.jpg'),
(5, 'Sweater', 'Fall will be your pup\'s favorite season when they get to wear this comfortable Combed Cotton Cable Knit Dog Sweater by Doggie Design in Oatmeal!', 14.99, 'sweater.jpg'),
(5, 'Winter Jacket', 'Easy to put on - very cozy and warm, full coverage, waterproof, attractive and appears well made. Adjustable, side snap closures that make it easy to tailor its fit. Warm and water resistant. The straps that attach to the back legs hold the coat in place during walks. Great fit, easy on and off as well as the fleece lining. Bring it for your pet in Winter! Let her/him feels warm and comfy.', 21.99, 'winterjacket.jpg');

CREATE TABLE Users (
Email NVARCHAR(40) PRIMARY KEY,
Password NVARCHAR(40) NOT NULL,
FirstName NVARCHAR(40) NOT NULL,
LastName NVARCHAR(40) NOT NULL);

CREATE VIEW AllProducts AS
SELECT 
	p.ProductID, 
	p.Name, 
    c.Name AS 'Category', 
    p.Description, 
    p.Price, 
    p.ImageFilename
FROM Products p 
JOIN Categories c ON p.CategoryID = c.CategoryID;