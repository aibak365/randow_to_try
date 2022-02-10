import os
Image_size=128
Screen_size=512
Num_of_til_on_side=4
Num_of_til_on_total=16
Margin=4
Asset_dir="images"
images_file=[x for x in os.listdir(Asset_dir) ]
assert len(images_file)==8

