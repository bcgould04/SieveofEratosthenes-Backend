# Sieve of Eratosthenes

I took two approaches here as well, the first being a standard list. I left the code for this in place, though 
commented out. While it would process the overhead was intensive. I 
switched out the List for a BitSet for better performance, but had to restrict the max value as we are doubling int 
to avoid out of range, as well as browser timeout and memory (heap) issues. 